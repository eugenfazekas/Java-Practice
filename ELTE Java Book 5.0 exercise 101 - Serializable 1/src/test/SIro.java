package test;

import java.io.*;

/**
Szerializálható gépjárművek kiírása.

@link.forrásfájl {@docRoot}/../data/serial/src SIro.java
@link.letöltés {@docRoot}/../data/serial SIro.jar
@since Java 2 Útikalauz programozóknak
*/
public class SIro {
    public static void main( String[] args )    {
        try    {
            Parkolo p = new Parkolo(4);
            p.parkol(new Gepjarmu("ABC-987", "Valaki"));
            p.parkol(new Autobusz("BUS-123", "BKV", 40));
            p.parkol(new Teherauto("TEH-456", "Fosped", 5));
            p.parkol(new Mikrobusz("MIC-789", "Maszek", 8));
            p.print();

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("p.tmp") );
            out.writeObject( p );
            out.close();
	    }
        catch( Exception ee )    {
            System.err.println( ee.toString() );
        }
    }
}