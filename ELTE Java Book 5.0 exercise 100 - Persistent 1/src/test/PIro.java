package test;

import java.io.*;

/**
Perzistens gépjárművek kiírása.

@link.forrásfájl {@docRoot}/../data/serial/src PIro.java
@link.letöltés {@docRoot}/../data/serial PIro.jar
@since Java Útikalauz programozóknak 1.1
*/
public class PIro{
    public static void main( String[] args ) {
        try {
            PGepjarmu lista[] = new PGepjarmu[3];
            lista[0] = new PGepjarmu("ABC-987", "Valaki");
            lista[1] = new PAutobusz("BUS-123", "BKV", 40);
            lista[2] = new PTeherauto("TEH-456", "Fosped", 5);

            for( int i = 0; i < 3; i++ ) {
                lista[i].print();
            }
            Persistent.OutputStream out =
                new Persistent.OutputStream(
                    new FileOutputStream("gepjarmu.tmp") );

            for( int i = 0; i < 3; i++ ) {
                out.writePersistent( lista[i] );
            }
            out.close();
        }
        catch( Exception ee )
        {    System.err.println( ee.toString() );     }
    }
}