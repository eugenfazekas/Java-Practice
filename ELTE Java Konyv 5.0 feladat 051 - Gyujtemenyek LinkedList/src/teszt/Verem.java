package teszt;

import java.util.*;

/**
Verem implement�ci�ja LinkedList-tel.
Postfix kifejez�seket �rt�kel ki, amelyek eg�sz sz�mok
�sszead�s�t �s szorz�s�t tartalmazz�k. A kifejez�sek elemeit a
parancssorban param�terekk�nt kell megadnunk, a szorz�sra a <em>pont</em> karakter szolg�l.

@link.forr�sf�jl {@docRoot}/../data/collection/src Verem.java
@link.let�lt�s {@docRoot}/../data/collection Verem.jar
@since Java 2 �tikalauz programoz�knak
*/
public class Verem<E> extends LinkedList<E> {
    /** Verzi�sz�m. */
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
            System.out.println("Eredm�ny: " + s1);
        }
        catch(Exception e) {
            System.out.println("Hib�s kifejez�s!");
        }
    }
}