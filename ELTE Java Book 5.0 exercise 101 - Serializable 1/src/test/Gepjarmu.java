package test;

import java.io.*;

/**
Szerializálható gépjármű megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src Gepjarmu.java
@since Java 2 Útikalauz programozóknak
*/
public class Gepjarmu implements Serializable {
    /** Verziószám */
    private final static long serialVersionUID = 15L;

    public Gepjarmu(String r, String t)    {
        rendszam = r;
        tulajdonos = t;
    }
    public void print()    {
         System.out.println( "Altalanos gepjarmu, rendszam="+rendszam+
                                       " tulajdonos="+tulajdonos);
    }
    protected String rendszam;
    protected transient String tulajdonos;
    private final static String ismeretlen = new String("Ismeretlen");
/**
 A tulajdonos alapertelmezett ertekenek beallitasa
 */
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException    {
        in.defaultReadObject();
        tulajdonos = ismeretlen;
    }
}
