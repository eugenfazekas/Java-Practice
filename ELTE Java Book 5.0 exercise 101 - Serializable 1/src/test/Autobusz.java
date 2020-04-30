package test;

import java.io.*;

/**
Szerializ�lhat� aut�busz megval�s�t�s.

@link.forr�sf�jl {@docRoot}/../data/serial/src Autobusz.java
@since Java 2 �tikalauz programoz�knak
*/
public class Autobusz extends Gepjarmu {
    /** Verzi�sz�m */
    private final static long serialVersionUID = 15L;

    public Autobusz(String r, String t, int f)    {
        super( r, t );
        ferohely = f;
    }
    public void print()    {
        System.out.println( "Autobusz, rendszam="+rendszam+
                     " tulajdonos="+tulajdonos+" ferohely="+ferohely);
    }
    private int ferohely;
/**
 A tulajdonos atkuldese
 */
    private void writeObject(ObjectOutputStream out)
            throws IOException    {
        out.defaultWriteObject();
        out.writeUTF(tulajdonos);
    }
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException    {
        in.defaultReadObject();
        tulajdonos = in.readUTF();
    }
}