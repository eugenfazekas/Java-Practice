package teszt;

/**
Egyszerű számláló példa hibás kiírással.

@link.forrásfájl {@docRoot}/../data/thread/src SimpleCount1.java
@link.letöltés {@docRoot}/../data/thread SimpleCount1.jar
@since Java 2 Útikalauz programozóknak
*/
public class SimpleCount1 extends Thread {
  static Integer n = 1;                      // Osztály szintű számláló

  public void run() {
    for (int i = 1; i <= 4; ++i) {
      System.out.print(n + " ");             // kiírjuk, majd
      n++;                                   // növeljük
    }
  }

  public static void main(String args[]) {
    Thread thread1 = new SimpleCount1(),     // Két szálat létrehozunk,
      thread2 = new SimpleCount1();
    thread1.start();                         // majd elindítunk
    thread2.start();
  }
}