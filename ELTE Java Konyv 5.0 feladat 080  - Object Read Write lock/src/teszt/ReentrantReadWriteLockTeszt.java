package teszt;

import java.util.concurrent.locks.*;

/**
Író/olvasó probléma reentráns író-olvasó lakattal.

@link.forrásfájl {@docRoot}/../data/thread/src ReentrantReadWriteLockTeszt.java
@link.letöltés {@docRoot}/../data/thread ReentrantReadWriteLockTeszt.jar
@since Java 2 Útikalauz programozóknak
*/
public class ReentrantReadWriteLockTeszt extends Thread {

  public static Integer data = new Integer(0);
  // lakat létrehozása
  public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

  private int ID;
  private boolean running = true;

  public ReentrantReadWriteLockTeszt(int ID) { super(); this.ID = ID; }

  public void run() {
    int dummy;
    System.out.println("indulok");
    while (running) {
      write( (int) (100.0 * Math.random())); // egy írás
      for(int i = 0; i < 1 + (int) (10.0 * Math.random()); i++)  {
        dummy = read(); // több olvasás
        try { sleep(10 + (int) (490.0 * Math.random())); }
        catch (InterruptedException e) {}
      }
    }
  }

  public void finish() { running = false; }

  public int read() {
    int readData;
    lock.readLock().lock(); // olvasó lakat lezárása
    try {
      readData = data;
      System.out.println( "Read: " + ID + "-->" + readData);
    } finally {
      lock.readLock().unlock(); // biztonságos felszabadítás
    }
    return readData;
  }

  public void write( int writeData ) {
    lock.writeLock().lock(); // író lakat lezárása
    try {
      data = writeData;
      System.out.println( "Write:" + ID + "-->" + writeData);
    } finally {
      lock.writeLock().unlock(); // biztonságos felszabadítás
    }
  }

  static public void main(String args[]) {
    int id = 0;
    ReentrantReadWriteLockTeszt[] workers = new ReentrantReadWriteLockTeszt[10];
    for (int i = 0; i < workers.length; ++i) {
      workers[i] = new ReentrantReadWriteLockTeszt(i);
      workers[i].start();
    }
    try {
      Thread.sleep(12000);
    } catch (InterruptedException e) {}
    for (ReentrantReadWriteLockTeszt worker : workers) {
      worker.finish();
    }
  }
}