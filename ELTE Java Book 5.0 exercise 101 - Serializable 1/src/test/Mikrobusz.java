package test;

import java.io.*;

/**
Szerializálható mikrobusz megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src Mikrobusz.java
@since Java 2 Útikalauz programozóknak
*/
public class Mikrobusz extends Gepjarmu {
    /** Verziószám */
    private final static long serialVersionUID = 15L;

    public Mikrobusz(String r, String t, int u)    {
        super( r, t );
        ulesek = u;
    }
    public void print()    {
        System.out.println( "Mikrobusz, rendszam="+rendszam+
                     " tulajdonos="+tulajdonos+" ulesek szama="+ulesek);
    }
    private int ulesek;
/**
 A Mikrobusz helyett Autobusz eltárolása
 */
    public Object writeReplace() throws ObjectStreamException
    {
        return new Autobusz( super.rendszam, super.tulajdonos, ulesek - 1);
    }
}