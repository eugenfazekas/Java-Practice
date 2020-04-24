package teszt;


/**
Egy lehets�ges megold�s a stop() helyettes�t�s�re Thread hivatkoz�ssal.

@link.forr�sf�jl {@docRoot}/../data/thread/src StopThread2.java
@link.let�lt�s {@docRoot}/../data/thread StopThread2.jar
@since Java 2 �tikalauz programoz�knak
*/
public class StopThread2 extends Thread {
  private volatile Thread thread = this;

  public void finish() {           // a le�ll�sn�l jelezz�k, hogy m�r nem kell
    thread = null;                 // a referencia null-ra �ll�tva
  }

  public void run() {
    while ( thread == this ) {     // futhat-e m�g a sz�l
      System.out.println("Hell�, ez itt a " + getName());
      try { sleep(300); } catch (InterruptedException e) {}
    }
  }

  public static void main(String[] args) {
    StopThread2 a;

    a = new StopThread2();
    System.out.println("Ind�t�s...");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}
    System.out.println("Stop thread");
    a.finish();
    System.out.println("The End");
  }
}