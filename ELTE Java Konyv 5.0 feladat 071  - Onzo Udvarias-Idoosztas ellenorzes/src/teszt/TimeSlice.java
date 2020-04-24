package teszt;

/**
Időosztás vizsgálata.

@link.forrásfájl {@docRoot}/../data/thread/src TimeSlice.java
@link.letöltés {@docRoot}/../data/thread TimeSlice.jar
@since Java 2 Útikalauz programozóknak
*/
class TimeSlice extends Thread {
  volatile int count = 0;
  volatile boolean running = true;

  public int getCount() {
    return count;
  }

  public void finish() {
    running = false;
  }

  public void run() {
    while (running) ++count;
  }

  static public void main(String s[]) {
    TimeSlice a, b;
    int threshold;

    a = new TimeSlice();   b = new TimeSlice();
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    System.out.println("Starting...");
    a.start(); b.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}
    System.out.println("Stopping...");
    a.finish(); b.finish();

    System.out.println("Thread a: " + a.getCount());
    System.out.println("Thread b: " + b.getCount());

    // Ha nagy az eltérés => nem időosztásos
    if (Math.abs(Math.log((double)a.getCount() / (double)b.getCount())) > 0.02 )
      System.out.println("A rendszer valószínuleg időosztásos");
    else
      System.out.println("A rendszer NEM időosztásos");
  }
}