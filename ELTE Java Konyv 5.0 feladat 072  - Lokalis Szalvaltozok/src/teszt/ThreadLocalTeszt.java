package teszt;

import java.util.*;
import java.text.*;

/**
Lokális szálváltozók.

@link.forrásfájl {@docRoot}/../data/thread/src ThreadLocalTeszt.java
@link.letöltés {@docRoot}/../data/thread ThreadLocalTeszt.jar
@since Java 2 Útikalauz programozóknak
*/
public class ThreadLocalTeszt extends Thread {

/**
Ez lesz az az osztály, ami példányosítva tartalmazza a
szálankénti objektumot (itt éppen egy egyedi dátum).
*/
static class MyThreadLocal extends ThreadLocal<Date> {
  protected Date initialValue() {                // ezt átírva adjuk az
    Date d = new Date();                         // új értéket
    System.out.println("\tThreadLocal initialValue-> " +
             DateFormat.getTimeInstance().format(d));
    return d;
  }
}

  static private MyThreadLocal local = new MyThreadLocal();

  ThreadLocalTeszt(String name) {
    super(name);
    System.out.println(getName() + " konstruktora => " +
             DateFormat.getTimeInstance().format(local.get()));
  }

  public void run() {
    for (int i = 0; i < 6; ++i) {
      System.out.println(getName() + " => " +
               DateFormat.getTimeInstance().format(local.get()));
      try { Thread.sleep(900); } catch (InterruptedException e) {}
    }
  }

  static public void main(String args[]) {
    System.out.println("Néhány ThreadLocalTeszt objektum létrehozása");
    ThreadLocalTeszt a = new ThreadLocalTeszt("a szál");
    ThreadLocalTeszt b = new ThreadLocalTeszt("b szál");
    ThreadLocalTeszt c = new ThreadLocalTeszt("c szál");
    a.start();
    try { Thread.sleep(2000); } catch (InterruptedException e) {}
    b.start();
    try { Thread.sleep(3000); } catch (InterruptedException e) {}
    c.start();
  }
}