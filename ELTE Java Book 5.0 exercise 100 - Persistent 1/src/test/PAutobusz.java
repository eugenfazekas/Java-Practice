package test;

import java.io.*;

/**
Perzistens autóbusz megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src PAutobusz.java
@since Java Útikalauz programozóknak 1.1
*/
public class PAutobusz extends PGepjarmu {
    public PAutobusz(String r, String t, int f) {
        super( r, t );
        ferohely = f;
    }
    public void print() {
        System.out.println( "Autóbusz, rendszám="+rendszam+
                     " tulajdonos="+tulajdonos+" férőhely="+ferohely);
    }
    private int ferohely;
/*
 *  A Persistent interfész megvalósítása
 */
    public PAutobusz() {
        super( ismeretlen, ismeretlen);
        ferohely = 0;
    }
    public void write(Persistent.Output out) throws IOException {
        super.write(out);
        out.writeInt(ferohely);
    }
    public void read(Persistent.Input in) throws IOException {
        super.read(in);
        ferohely = in.readInt();
    }
}