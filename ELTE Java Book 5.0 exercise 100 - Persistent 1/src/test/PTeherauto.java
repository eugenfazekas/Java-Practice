package test;

import java.io.*;

/**
Perzistens teherautó megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src PTeherauto.java
@since Java Útikalauz programozóknak 1.1
*/
public class PTeherauto extends PGepjarmu {
    public PTeherauto(String r, String t, int s) {
        super( r, t );
        maxteher = s;
    }
    public void print() {
        System.out.println( "Teherautó, rendszám="+rendszam+
               " tulajdonos="+tulajdonos+" max.terhelés="+maxteher);
    }
    private int maxteher;
/*
 *  A Persistent interfész megvalósítása
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