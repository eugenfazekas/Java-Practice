package teszt;

import java.lang.reflect.*;

/**
Szelektív nyomkövetés.

@link.forrásfájl {@docRoot}/../data/reflect/src CounterTrace.java
@link.letöltés {@docRoot}/../data/reflect CounterTrace.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
public class CounterTrace {

    interface ICounter {
        public void inc();
        public void dec();
    } // ICounter

    static class Counter implements ICounter {
        protected int counter;
        public void inc() { counter++; }
        public void dec() { counter--; }
        public String toString() {
            return Integer.toString(counter);
        }
    } //Counter

    class TCounter implements ICounter {
        private ICounter traced;
        public TCounter(ICounter obj) { traced = obj; }
        public void inc() {
            System.out.println("metóduskezdet: inc");
    	traced.inc();
            System.out.println("metódus vége: inc");
        }
        public void dec() {
            System.out.println("metóduskezdet: dec");
    	traced.dec();
            System.out.println("metódus vége: dec");
        }
        public String toString() {
            System.out.println("metóduskezdet: toString");
            String result = traced.toString();
            System.out.println("metódus vége: toString");
    	return result;
        }
    } //TCounter

    static class Tracer implements InvocationHandler {
        private Object traced;

        public static Object newInstance(Object obj) {
            return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new Tracer(obj));
        }

        private Tracer(Object obj) {
            traced = obj;
        }

        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            Object result;
            try {
                System.out.println("metóduskezdet: " + m.getName());
                result = m.invoke(traced, args);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                } catch (Exception e) {
                    throw new RuntimeException("unexpected invocation exception: " +
                           e.getMessage());
                } finally {
                    System.out.println("metódus vége: " + m.getName());
                }
            return result;
        }
    } // Tracer

    public static void main(String[] args) {
        ICounter real = new Counter();
        real.inc(); // számláló értéke 1
        real.inc(); // számláló értéke 2
        real.dec(); // számláló értéke 1
        // kiíratáskot meghívódik a számláló toString metódusa
        System.out.println("real counter = " + real);

        // becsomagoljuk az igazi számlálót egy nyomkövető objektumba
        ICounter proxy = (ICounter)Tracer.newInstance(real);
        proxy.inc(); // számláló értéke 2; nyomkövetés
        real.inc();  // számláló értéke 3; nincs nyomkövetés!
        proxy.dec(); // számláló értéke 2; nyomkövetés
        // a nyomkövetésen keresztül hívódik meg a toString metódus
        System.out.println("proxy counter = " + proxy);
    }
} // CounterTrace