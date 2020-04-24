package teszt;


import java.util.*;
import java.util.concurrent.atomic.*;

/**
Zárolás és atomi növelés összehasonlítása.

@link.forrásfájl {@docRoot}/../data/thread/src AtomicMeasure.java
@link.letöltés {@docRoot}/../data/thread AtomicMeasure.jar
@since Java 2 Útikalauz programozóknak
*/
public class AtomicMeasure {

  // Atomi számláló
  public static AtomicInteger atomicCounter = new AtomicInteger(0);

  public static class AtomicUpdater implements Runnable {
    public AtomicUpdater() {}
    public void run() {
      for (int i = 0; i < 10000000; ++i) {
        int cnt = atomicCounter.getAndIncrement(); // atomi növelés
      }
    }
  }

  // Zárolással használt számláló
  public static Integer lockCounter = new Integer(0);

  public static class LockUpdater implements Runnable {
    public LockUpdater() {}
    public void run() {
      for (int i = 0; i < 10000000; ++i) {
        synchronized (lockCounter) {
          int cnt = ++lockCounter;   // zárolás
        }
      }
    }
  }

  public static void atomicTest() {
    Date start = new Date();  // Mérjük az időt
    Thread[] threads = new Thread[20]; // húsz növelő szál
    for (int i = 0; i < threads.length; ++i) {
      threads[i] = new Thread(new AtomicUpdater());
      threads[i].start();
    }
    for (int i = 0; i < threads.length; ++i) {
      try {
        threads[i].join(); // megvárjuk a szál terminálását
      } catch (InterruptedException e) {}
    }
    Date stop = new Date();
    System.out.println("Atomi frissites: " +
             (stop.getTime() - start.getTime()) + " ms");
  }

  public static void lockTest() {
    Date start = new Date();
    Thread[] threads = new Thread[20];
    for (int i = 0; i < threads.length; ++i) {
      threads[i] = new Thread(new LockUpdater());
      threads[i].start();
    }
    for (int i = 0; i < threads.length; ++i) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {}
    }
    Date stop = new Date();
    System.out.println("Zarolo frissites: " +
             (stop.getTime() - start.getTime()) + " ms");
  }

  public static void main(String[] args) {
    atomicTest();
    lockTest();
  }
}