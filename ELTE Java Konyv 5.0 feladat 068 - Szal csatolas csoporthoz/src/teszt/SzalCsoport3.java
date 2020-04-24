package teszt;
/**
Szálak egyszeri megszakítása.

@link.forrásfájl {@docRoot}/../data/thread/src SzalCsoport3.java
@link.letöltés {@docRoot}/../data/thread SzalCsoport3.jar
@since Java 2 Útikalauz programozóknak
*/
public class SzalCsoport3 extends Thread {
  SzalCsoport3(ThreadGroup tg, String name) { super(tg, name); }

  public void run() {
    try {
      while (true) {
        System.out.print(getName() + " - fut \n");
        sleep(400);
      }
    } catch (InterruptedException e) {}
  }

  public static void main(String args[]) {
    ThreadGroup group = new ThreadGroup("seged"),
      mainGroup = Thread.currentThread().getThreadGroup();
    SzalCsoport3[] threads = new SzalCsoport3[4];

    for (int i = 0; i < threads.length; ++i) {
      threads[i] = new SzalCsoport3(group, i + ". szál");
    }

    for (int i = 0; i < threads.length; ++i) {
      threads[i].start();
    }

    System.out.println("Fo csoport: " + mainGroup.getName() +
             ", Szál#: " + mainGroup.activeCount());
    System.out.println("Csoport: " + group.getName() +
             ", Szál#: " + group.activeCount());

    try { Thread.sleep(1800); } catch(InterruptedException e) {}
    System.out.println("interrupt!!!");
    group.interrupt();
  }
}