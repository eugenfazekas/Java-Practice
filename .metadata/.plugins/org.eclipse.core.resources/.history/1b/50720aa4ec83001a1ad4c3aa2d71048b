package teszt;

/**
Példa join használatára.

@link.forrásfájl {@docRoot}/../data/thread/src JoinTeszt.java
@link.letöltés {@docRoot}/../data/thread JoinTeszt.jar
@since Java 2 Útikalauz programozóknak
*/
public class JoinTeszt {

static class MyThread1 extends Thread {
  public void run() {
    System.out.println( getName() + " fut" );
    for (int i=0; i<5; i++) {
      try { sleep(500); } catch (InterruptedException e) {}
      System.out.println( "Helló,  itt a " + getName() );
    }
    System.out.println( getName() + "befejeződött" );
  }
}

static class MyThread2 extends Thread {
  private Thread wait4me;

  MyThread2(Thread target) {            // Átadjuk a szálat,
    super();
    wait4me = target;                   // amire várunk
  }

  public void run() {
    System.out.println( getName() + " várakozik " +
                        wait4me.getName() + "-ra");
    try { wait4me.join(); } catch (InterruptedException e) {}
    for (int i=0; i<5; i++) {
      try { sleep(500); } catch (InterruptedException e) {}
      System.out.println( "Helló, itt a " + getName() );
    }
  }
}

  static public void main(String args[]) {
    MyThread1 a;
    MyThread2 b;

    a = new MyThread1();
    b = new MyThread2(a);
    b.start();
    a.start();
  }
}