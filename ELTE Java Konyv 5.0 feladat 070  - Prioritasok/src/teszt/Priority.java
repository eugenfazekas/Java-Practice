package teszt;
/**
Példa priorítások használatára.

@link.forrásfájl {@docRoot}/../data/thread/src Priority.java
@link.letöltés {@docRoot}/../data/thread Priority.jar
@since Java 2 Útikalauz programozóknak
*/
public class Priority extends Thread {
  volatile boolean running = true;
  Priority(String name) {
    super(name);
  }

  public void finish() { running = false; }

  public void run() {
    while (running) {
      for (int i = 0; i < 1000000; ++i);  // aktív várakozás
      System.out.println( getName() );
      yield();  // következő ütemezett szál futhat
    }
  }

  static public void main(String s[]) {
    Priority a, b, c;
    int var = 50;

    a = new Priority("a thread");
    b = new Priority("b thread");
    c = new Priority("c thread");
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    System.out.println("Start... " + a.getPriority() + "," +
             b.getPriority() + "," + c.getPriority());
    a.start(); b.start(); c.start();

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    b.setPriority(Thread.NORM_PRIORITY + 4); // magas prioritás
    System.out.println("Start... " + a.getPriority() + "," +
             b.getPriority() + "," + c.getPriority());

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    b.setPriority(Thread.NORM_PRIORITY - 4); // alacsony prioritás
    System.out.println("Start... " + a.getPriority() + "," +
             b.getPriority() + "," + c.getPriority());

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    b.setPriority(Thread.NORM_PRIORITY); // normál prioritás
    System.out.println("Start... " + a.getPriority() + "," +
             b.getPriority() + "," + c.getPriority());

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    System.out.println("Stopping...");
    a.finish(); b.finish(); c.finish();
  }
}