package teszt;

/**
Egyszerű számláló példa rendes sorrenddel.

@link.forrásfájl {@docRoot}/../data/thread/src SimpleCount2.java
@link.letöltés {@docRoot}/../data/thread SimpleCount2.jar
@since Java 2 Útikalauz programozóknak
*/
public class SimpleCount2 extends Thread {
  private static final int n[] = {1};                // Osztály szintű számláló

  public void run() {
    for (int i = 1; i <= 4; ++i) {
      synchronized (n) {           // szinkronizálunk
        System.out.print(n[0] + " "); // kiírjuk, majd növeljük
        n[0]++;
      }                                // Szinkronizációs blokk vége
    }
  }

  public static void main(String args[]) {
    Thread thread1 = new SimpleCount2(),      // Két szálat létrehozunk,
      thread2 = new SimpleCount2();
    thread1.start();                          // majd elindítunk
    thread2.start();
  }
}