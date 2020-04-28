package test;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
Egyszeru tesztprogram a létrehozott naplózási szolgáltató objektumunk kipróbálására.
Használatakor ne feledjünk el a következo jogokat megadni!
<pre>
grant signedBy "utikalauz" {
  permission java.net.SocketPermission "localhost", "connect";
};
</pre>

@link.forrásfájl {@docRoot}/../data/rmi/src NaploProba.java
@link.letöltés {@docRoot}/../data/rmi NaploProba.jar
@since Java 2 Útikalauz programozóknak
*/
public class NaploProba {
  public static void main(String args[]) {
    System.setSecurityManager(new RMISecurityManager());
    try {
      NaploInterface ni=(NaploInterface) Naming.lookup("Naplo");
      ni.naploz("Elso esemény...");
      ni.naploz("Második esemény...");
      ni.naploz("Harmadik esemény...");
    } catch (Exception e) {
      System.out.println("Hiba: "+e);
    }
  }
}