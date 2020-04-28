package test;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.io.*; // Fájlba is naplózunk

/**
A távoli naplózási interfészt implementáló objektumok osztálya.
Használatakor ne feledjünk el a következő jogokat megadni!
<pre>
grant signedBy "utikalauz" {
  permission java.io.FilePermission "naplo.log", "write";
  permission java.net.SocketPermission "localhost", "accept,connect";
};
</pre>

@link.forrásfájl {@docRoot}/../data/rmi/src Naplo.java
@link.letöltés {@docRoot}/../data/rmi Naplo.jar
@since Java 2 Útikalauz programozóknak
*/
public class Naplo extends UnicastRemoteObject implements NaploInterface {

    /** Verziószám. */
    private final static long serialVersionUID = 15L;

  BufferedWriter bw = null; // A naplófájl elérése

  public Naplo() throws java.rmi.RemoteException {
    super(); // Ez exportálja a távoli objektumot
    try {
      FileWriter fw = new FileWriter("naplo.log"); // fájl
      bw = new BufferedWriter(fw); // bufferelt író létrehozása
    } catch (IOException e) {
      System.out.println("Naplófájl nem hozható létre.");
      System.out.println("Lemezre naplózás szünetel.");
    }
  }

  public void naploz(String szoveg) throws java.rmi.RemoteException {
    System.out.println(szoveg); // Képernyőre is naplózunk
    if (bw != null) { // Ha tudunk, akkor fájlba is
      try {
        bw.write(szoveg);
        bw.newLine();
        bw.flush(); // Kiíratjuk a diszkre
      } catch (IOException e) {
        System.out.println(">> Naplófájl nem írható. <<");
      }
    }
  }

  public static void main(String args[]) {
    System.setSecurityManager(new RMISecurityManager());
    try {
      Naplo n = new Naplo();
      Naming.rebind("Naplo",n);     // Bejegyzi a registrybe
      System.out.println("Naplózás fut ...");
    } catch (Exception e) {
      System.out.println("Naplózás nem indítható ...");
      System.out.println("Hiba oka:"+e.getMessage());
    }
  }
}