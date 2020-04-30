package main.upgraded;

import java.io.*;

public class FejlesztettTIro  {
    public static void main( String args[])  {
        Teglalap t = new Teglalap( new Teglalap.Pont(15, 25),
                                   new Teglalap.Pont(35, 45));
        t.print();
        try {
            ObjectOutputStream out =
                new ObjectOutputStream(
                    new FileOutputStream("tegla.tmp") );
            out.writeObject( t );
            out.close();
        } catch( Exception ee ) {System.err.println(ee.toString());}
    }
   
}





