package test;


import java.io.*;

/**
Perzistens gépjárművek visszaolvasása.

@link.forrásfájl {@docRoot}/../data/serial/src POlvaso.java
@link.letöltés {@docRoot}/../data/serial POlvaso.jar
@since Java Útikalauz programozóknak 1.1
*/
public class POlvaso{
    public static void main( String[] args ) {
        try {
            PGepjarmu lista[] = new PGepjarmu[3];
            Persistent.InputStream in =
                new Persistent.InputStream(
                    new FileInputStream("gepjarmu.tmp") );

            for( int i = 0; i < 3; i++ ) {
               lista[i] = (PGepjarmu) in.readPersistent();
            }
            in.close();

            for( int i = 0; i < 3; i++ ) {
               lista[i].print();
            }
        }
        catch( Exception ee )
        {    System.err.println( ee.toString() );     }
    }
}