package test;

import java.io.*;

/**
Perzistens gépjármű megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src PGepjarmu.java
@since Java Útikalauz programozóknak 1.1
*/
public class PGepjarmu implements Persistent {
    public PGepjarmu(String r, String t) {
        rendszam = r;
        tulajdonos = t;
    }
    public void print() {
         System.out.println( "Általános gépjármű, rendszám="+rendszam+
                                       " tulajdonos="+tulajdonos);
    }
    protected String rendszam;
    protected String tulajdonos;
    protected final static String ismeretlen = new String("Ismeretlen");

/*
 *    A Persistent interfész megvalósítása
 */
    public PGepjarmu() {
        rendszam = ismeretlen;
        tulajdonos = ismeretlen;
    }
    public void write(Persistent.Output out) throws IOException {
        out.writeUTF(rendszam);
        out.writeUTF(tulajdonos);
    }
    public void read(Persistent.Input in) throws IOException {
        rendszam = in.readUTF();
        tulajdonos = in.readUTF();
    }
}