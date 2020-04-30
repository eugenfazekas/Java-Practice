package test;

import java.io.*;

/**
Szerializálható gépjárműparkoló megvalósítás.

@link.forrásfájl {@docRoot}/../data/serial/src Parkolo.java
@since Java 2 Útikalauz programozóknak
*/
public class Parkolo implements Serializable {
    /** Verziószám */
    private final static long serialVersionUID = 15L;

    public Parkolo(int kapacitas)  {
        lista   = new Gepjarmu[kapacitas];
        foglalt = 0;
    }
    public void parkol(Gepjarmu gj) throws Exception  {
        if ( foglalt < lista.length )  {
            lista[foglalt] = gj;
            ++foglalt;
        }
        else  {
            throw new Exception("Parkolo megtelt");
        }
    }
    public void print()  {
        for( int i = 0; i < foglalt; i++ )    {
                lista[i].print();
        }
    }
    private Gepjarmu[] lista;
    private int foglalt;
}