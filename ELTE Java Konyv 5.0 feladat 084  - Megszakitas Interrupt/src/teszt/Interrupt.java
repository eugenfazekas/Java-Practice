package teszt;

/**
Interrupt-ot bemutat� program.

@link.forr�sf�jl {@docRoot}/../data/thread/src Interrupt.java
@link.let�lt�s {@docRoot}/../data/thread Interrupt.jar
@since Java 2 �tikalauz programoz�knak
*/
public class Interrupt extends Thread {
  public void run() {
    for (int i = 0; i < 10; ++i) {
      try {
        System.out.println("V�rok f�l m�sodpercet... [" + i + "]");
        sleep(500);
      } catch (InterruptedException e) {      // amint kiv�lt�dik, ki�rjuk
        System.out.println("Kiv�tel a run()-ban: " + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    Interrupt a;

    a = new Interrupt();
    System.out.println("Ind�t�s...");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}

    System.out.println("Sz�l megszak�t�sa");
    a.interrupt();
    System.out.println("Meg van szak�tva?" + a.isInterrupted());
    try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // V�rakozunk, de mivel kiv�tel teljes�l�se t�r�lte a flag-et,
    // m�r csak false �rt�ket kapunk
    System.out.println("Meg van szakitva?" + a.isInterrupted());
  }
}