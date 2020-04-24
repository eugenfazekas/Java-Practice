package teszt;


/**
Klónozási példa.

@link.forrásfájl {@docRoot}/../data/lang/src ClonePelda.java
@link.letöltés {@docRoot}/../data/lang ClonePelda.jar
@since Java Útikalauz programozóknak
*/
public class ClonePelda implements Cloneable {
  boolean  klonozhato;
  int      tomb[];

  public ClonePelda(boolean b) {                                  // Konstruktor
     klonozhato = b;
     tomb = new int[3];
     for (int i=0; i < 3; ++i) {
       tomb[i] = 0;
     }
  }
  public void tombelem(int index, int ertek) {        // Egy tömbelem módosítása
    try {
      tomb[index] = ertek;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Hibás index");
    }
  }
  public String toString() {
    return "cloneable ["+String.valueOf(tomb[0]) + ','  +
      String.valueOf(tomb[1]) + ',' + String.valueOf(tomb[2]) +
      "] klónozható : "+klonozhato;
  }
  public Object clone() throws CloneNotSupportedException {
    if (klonozhato) {
      try {
        ClonePelda cp = (ClonePelda)super.clone();
        cp.tomb = new int[3];
        System.arraycopy(tomb, 0, cp.tomb, 0, 3);
        return cp;
      } catch (CloneNotSupportedException e) {
        // Ez soha nem fordulhat elo, mert
        // implementáljuk a Cloneable-t
        throw new InternalError();
      }
    }
    else
      throw new CloneNotSupportedException();
  }

 
}