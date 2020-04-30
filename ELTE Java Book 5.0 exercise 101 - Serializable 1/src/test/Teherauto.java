package test;

import java.io.*;

/**
Szerializ�lhat� teheraut� megval�s�t�s.

@link.forr�sf�jl {@docRoot}/../data/serial/src Teherauto.java
@since Java 2 �tikalauz programoz�knak
*/
public class Teherauto extends Gepjarmu {
    /** Verzi�sz�m */
    private final static long serialVersionUID = 15L;

    public Teherauto(String r, String t, int s)    {
        super( r, t );
        maxteher = s;
    }
    public void print()    {
        System.out.println( "Teherauto, rendszam="+rendszam+
               " tulajdonos="+tulajdonos+" max.terheles="+maxteher);
    }
    private transient int maxteher;
}
