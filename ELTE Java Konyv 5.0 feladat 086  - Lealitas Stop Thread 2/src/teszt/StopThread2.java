package teszt;


/**
Egy lehetséges megoldás a stop() helyettesítésére Thread hivatkozással.

@link.forrásfájl {@docRoot}/../data/thread/src StopThread2.java
@link.letöltés {@docRoot}/../data/thread StopThread2.jar
@since Java 2 Útikalauz programozóknak
*/
public class StopThread2 extends Thread {
  private volatile Thread thread = this;

  public void finish() {           // a leállásnál jelezzük, hogy már nem kell
    thread = null;                 // a referencia null-ra állítva
  }

  public void run() {
    while ( thread == this ) {     // futhat-e még a szál
      System.out.println("Helló, ez itt a " + getName());
      try { sleep(300); } catch (InterruptedException e) {}
    }
  }

  public static void main(String[] args) {
    StopThread2 a;

    a = new StopThread2();
    System.out.println("Indítás...");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}
    System.out.println("Stop thread");
    a.finish();
    System.out.println("The End");
  }
}