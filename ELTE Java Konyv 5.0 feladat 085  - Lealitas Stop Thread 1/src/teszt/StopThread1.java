package teszt;



/**
Egy lehets�ges megold�s a stop() helyettes�t�s�re.

@link.forr�sf�jl {@docRoot}/../data/thread/src StopThread1.java
@link.let�lt�s {@docRoot}/../data/thread StopThread1.jar
@since Java 2 �tikalauz programoz�knak
*/
public class StopThread1 extends Thread {
  private volatile boolean isRunning = true;  //fut-e a sz�l

  public void finish() {  //A standard stop() helyettes�t�se
    isRunning = false;    //M�r nem fut...
  }

  public void run() {
    while ( isRunning ) {  //Csak am�g le nem �ll�tjuk a stopp() met�dussal
      System.out.println("Hell�, ez itt a " + getName());
      try { sleep(500); } catch (InterruptedException e) {}
    }
  }

  public static void main(String[] args) {
    StopThread1 a;

    a = new StopThread1();
    System.out.println("Ind�t�s...");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}

    System.out.println("Stop...");
    a.finish();
    try { Thread.sleep(1000); } catch (InterruptedException e) {}
    System.out.println("V�ge...");
  }
}