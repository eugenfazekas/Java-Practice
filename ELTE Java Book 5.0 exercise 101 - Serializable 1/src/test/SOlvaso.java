package test;

import java.io.*;

/**
Szerializált gépjárművek visszaolvasása.

@link.forrásfájl {@docRoot}/../data/serial/src SOlvaso.java
@link.letöltés {@docRoot}/../data/serial SOlvaso.jar
@since Java 2 Útikalauz programozóknak
*/
public class SOlvaso {
    public static void main( String[] args )    {
        try    {
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("p.tmp") );
            Parkolo p = (Parkolo) in.readObject();
            in.close();

            p.print();
        }
        catch( Exception ee )    {
            System.err.println( ee.toString() );
        }
    }
}