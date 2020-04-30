package main.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EredetiTIro  {
    public static void main( String args[])  {
        Teglalap t = new Teglalap( 10, 20, 30, 40);
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