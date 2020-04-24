package teszt;



import java.util.Iterator;
import java.util.NoSuchElementException;

/**
Végleges lista.

@link.forrásfájl {@docRoot}/../data/osztaly/inner/src Lista.java
@since Java Útikalauz programozóknak 1.1
*/
public class Lista {
    private Elem elso;

    private static class Elem {
        Object adat;
        Elem elozo, kovetkezo;

        Elem (Object adat, Elem elozo, Elem kovetkezo) {
            this.adat = adat;
            this.elozo = elozo;
            this.kovetkezo = kovetkezo;
        }
    }

    public void beszur (Object adat) {
        elso = new Elem(adat,null,elso);
        if (elso.kovetkezo != null)
            elso.kovetkezo.elozo = elso;
    }
    public void torol (Object adat) {
        Elem elem = keres(adat);
        if (elem != null)
            torol(elem);
    }
    private void torol (Elem elem) {
        if (elem == elso)
            elso = elem.kovetkezo;
        if (elem.elozo != null)
            elem.elozo.kovetkezo = elem.kovetkezo;
        if (elem.kovetkezo != null)
            elem.kovetkezo.elozo = elem.elozo;
    }
    private Elem keres (Object adat) {
        for (Elem elem = elso; elem != null; elem = elem.kovetkezo)
            if (elem.adat.equals(adat))
                return elem;
        return null;
    }
    public Iterator felsorol () {
        return new Iterator() {
            Elem aktualis = elso;
            Elem torolheto = null;

            public boolean hasNext () {
                return aktualis != null;
            }
            public Object next ()
            throws NoSuchElementException {
                if (aktualis != null) {
                    torolheto = aktualis;
                    Object adat = aktualis.adat;
                    aktualis = aktualis.kovetkezo;
                    return adat;
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            public void remove ()
            throws IllegalStateException {
                if (torolheto != null) {
                    torol(torolheto);
                    torolheto = null;
                }
                else {
                    throw new IllegalStateException();
                }
            }
        };
    }
    public void mindre (Muvelet muvelet) {
        for (Elem elem = elso; elem != null; elem = elem.kovetkezo)
            muvelet.vegrehajt(elem.adat);
    }

    static int multiplicitas(Lista lista, final Object minta) {
        final int[] n = { 0 };
        lista.mindre(new Muvelet() {
            public void vegrehajt (Object adat) {
                if (adat.equals(minta)) n[0]++;
            }
        });
        return n[0];
    }

}

interface Muvelet {
    void vegrehajt (Object adat);
}
