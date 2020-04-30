package main.test;

import java.io.*;

public class TOlvaso  {
    public static void main( String args[])  {
        Teglalap t = null;
        try {
            ObjectInputStream in =
                new ObjectInputStream(
                    new FileInputStream("tegla.tmp") );
            t = (Teglalap) in.readObject();
            in.close();
            t.print();
        }
        catch( Exception ee )    {
            System.err.println( ee.toString() );
        }
    }
}


