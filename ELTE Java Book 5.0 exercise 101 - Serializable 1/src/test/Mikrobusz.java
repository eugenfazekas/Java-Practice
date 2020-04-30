package test;

import java.io.*;

/**
Szerializ�lhat� mikrobusz megval�s�t�s.

@link.forr�sf�jl {@docRoot}/../data/serial/src Mikrobusz.java
@since Java 2 �tikalauz programoz�knak
*/
public class Mikrobusz extends Gepjarmu {
    /** Verzi�sz�m */
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
 A Mikrobusz helyett Autobusz elt�rol�sa
 */
    public Object writeReplace() throws ObjectStreamException
    {
        return new Autobusz( super.rendszam, super.tulajdonos, ulesek - 1);
    }
}