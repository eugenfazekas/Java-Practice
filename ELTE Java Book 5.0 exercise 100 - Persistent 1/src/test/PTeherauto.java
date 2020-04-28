package test;

import java.io.*;

/**
Perzistens teheraut� megval�s�t�s.

@link.forr�sf�jl {@docRoot}/../data/serial/src PTeherauto.java
@since Java �tikalauz programoz�knak 1.1
*/
public class PTeherauto extends PGepjarmu {
    public PTeherauto(String r, String t, int s) {
        super( r, t );
        maxteher = s;
    }
    public void print() {
        System.out.println( "Teheraut�, rendsz�m="+rendszam+
               " tulajdonos="+tulajdonos+" max.terhel�s="+maxteher);
    }
    private int maxteher;
/*
 *  A Persistent interf�sz megval�s�t�sa
 */
    public PTeherauto() {
        super( ismeretlen, ismeretlen);
        maxteher = 0;
    }
    public void write(Persistent.Output out) throws IOException {
        super.write(out);
        out.writeInt(maxteher);
    }
    public void read(Persistent.Input in) throws IOException {
        super.read(in);
        maxteher = in.readInt();
    }
}