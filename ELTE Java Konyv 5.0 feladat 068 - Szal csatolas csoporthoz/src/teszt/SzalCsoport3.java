package teszt;
/**
Sz�lak egyszeri megszak�t�sa.

@link.forr�sf�jl {@docRoot}/../data/thread/src SzalCsoport3.java
@link.let�lt�s {@docRoot}/../data/thread SzalCsoport3.jar
@since Java 2 �tikalauz programoz�knak
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
      threads[i] = new SzalCsoport3(group, i + ". sz�l");
    }

    for (int i = 0; i < threads.length; ++i) {
      threads[i].start();
    }

    System.out.println("Fo csoport: " + mainGroup.getName() +
             ", Sz�l#: " + mainGroup.activeCount());
    System.out.println("Csoport: " + group.getName() +
             ", Sz�l#: " + group.activeCount());

    try { Thread.sleep(1800); } catch(InterruptedException e) {}
    System.out.println("interrupt!!!");
    group.interrupt();
  }
}