package test;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
Egyszeru tesztprogram a l�trehozott napl�z�si szolg�ltat� objektumunk kipr�b�l�s�ra.
Haszn�latakor ne feledj�nk el a k�vetkezo jogokat megadni!
<pre>
grant signedBy "utikalauz" {
  permission java.net.SocketPermission "localhost", "connect";
};
</pre>

@link.forr�sf�jl {@docRoot}/../data/rmi/src NaploProba.java
@link.let�lt�s {@docRoot}/../data/rmi NaploProba.jar
@since Java 2 �tikalauz programoz�knak
*/
public class NaploProba {
  public static void main(String args[]) {
    System.setSecurityManager(new RMISecurityManager());
    try {
      NaploInterface ni=(NaploInterface) Naming.lookup("Naplo");
      ni.naploz("Elso esem�ny...");
      ni.naploz("M�sodik esem�ny...");
      ni.naploz("Harmadik esem�ny...");
    } catch (Exception e) {
      System.out.println("Hiba: "+e);
    }
  }
}