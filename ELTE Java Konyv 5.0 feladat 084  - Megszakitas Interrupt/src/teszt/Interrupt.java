package teszt;

/**
Interrupt-ot bemutató program.

@link.forrásfájl {@docRoot}/../data/thread/src Interrupt.java
@link.letöltés {@docRoot}/../data/thread Interrupt.jar
@since Java 2 Útikalauz programozóknak
*/
public class Interrupt extends Thread {
  public void run() {
    for (int i = 0; i < 10; ++i) {
      try {
        System.out.println("Várok fél másodpercet... [" + i + "]");
        sleep(500);
      } catch (InterruptedException e) {      // amint kiváltódik, kiírjuk
        System.out.println("Kivétel a run()-ban: " + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    Interrupt a;

    a = new Interrupt();
    System.out.println("Indítás...");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}

    System.out.println("Szál megszakítása");
    a.interrupt();
    System.out.println("Meg van szakítva?" + a.isInterrupted());
    try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // Várakozunk, de mivel kivétel teljesülése törölte a flag-et,
    // már csak false értéket kapunk
    System.out.println("Meg van szakitva?" + a.isInterrupted());
  }
}