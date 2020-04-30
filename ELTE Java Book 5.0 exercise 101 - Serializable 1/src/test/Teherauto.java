package test;

import java.io.*;

/**
Szerializálható teherautó megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src Teherauto.java
@since Java 2 Útikalauz programozóknak
*/
public class Teherauto extends Gepjarmu {
    /** Verziószám */
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
