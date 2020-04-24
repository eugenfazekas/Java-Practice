package teszt;

import java.util.*;

/**
Verem implementációja LinkedList-tel.
Postfix kifejezéseket értékel ki, amelyek egész számok
összeadását és szorzását tartalmazzák. A kifejezések elemeit a
parancssorban paraméterekként kell megadnunk, a szorzásra a <em>pont</em> karakter szolgál.

@link.forrásfájl {@docRoot}/../data/collection/src Verem.java
@link.letöltés {@docRoot}/../data/collection Verem.jar
@since Java 2 Útikalauz programozóknak
*/
public class Verem<E> extends LinkedList<E> {
    /** Verziószám. */
    private final static long serialVersionUID = 15L;

    public Verem(Collection<E> c) {
        super(c);
    }
    public void push(E o) {
        addFirst(o);
    }
    public Object top() {
        return getFirst();
    }
    public E pop() {
        return removeFirst();
    }

    public static void main(String[] args)
    {
        Collection<String> c = Arrays.asList(args);
        Verem<String> v = new Verem<String>(c);
        String s1 = null, s2 = null, s3 = null;
        try {
            s1 = (String)(v.pop());
            while(!v.isEmpty()) {
                s2 = (String)(v.pop());
                s3 = (String)(v.pop());
                if(s3.compareTo("+")==0) {
                    s1 = new String(String.valueOf(
                         Integer.valueOf(s1).intValue()
                         + Integer.valueOf(s2).intValue()));
                }
                else if(s3.compareTo(".")==0) {
                    s1 = new String(String.valueOf(
                         Integer.valueOf(s1).intValue()
                         * Integer.valueOf(s2).intValue()));
                }
            }
            System.out.println("Eredmény: " + s1);
        }
        catch(Exception e) {
            System.out.println("Hibás kifejezés!");
        }
    }
}