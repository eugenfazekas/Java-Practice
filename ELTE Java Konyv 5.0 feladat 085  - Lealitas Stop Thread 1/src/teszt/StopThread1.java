package teszt;



/**
Egy lehetséges megoldás a stop() helyettesítésére.

@link.forrásfájl {@docRoot}/../data/thread/src StopThread1.java
@link.letöltés {@docRoot}/../data/thread StopThread1.jar
@since Java 2 Útikalauz programozóknak
*/
public class StopThread1 extends Thread {
  private volatile boolean isRunning = true;  //fut-e a szál

  public void finish() {  //A standard stop() helyettesítése
    isRunning = false;    //Már nem fut...
  }

  public void run() {
    while ( isRunning ) {  //Csak amíg le nem állítjuk a stopp() metódussal
      System.out.println("Helló, ez itt a " + getName());
      try { sleep(500); } catch (InterruptedException e) {}
    }
  }

  public static void main(String[] args) {
    StopThread1 a;

    a = new StopThread1();
    System.out.println("Indítás...");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}

    System.out.println("Stop...");
    a.finish();
    try { Thread.sleep(1000); } catch (InterruptedException e) {}
    System.out.println("Vége...");
  }
}