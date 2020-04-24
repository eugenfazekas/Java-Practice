package teszt;

/**
Egy rövid példa.

@link.forrásfájl {@docRoot}/../data/reflect/src Whoami.java
@link.letöltés {@docRoot}/../data/reflect Whoami.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
public class ShowArray {
    public static void tell(Object o) {
        System.out.println("Az én nevem " + o.getClass().getName() +
            ", és a(z) " + o.getClass().getSuperclass().getName() +
            " leszármazottja vagyok.");
    }
    public static void main(String args[]) {
        tell(new ShowArray());
    }
}