package teszt;

/**
Termelő - fogyasztó probléma szinkronizációs üzenetekkel.

@link.forrásfájl {@docRoot}/../data/thread/src WaitNotify.java
@link.letöltés {@docRoot}/../data/thread WaitNotify.jar
@since Java 2 Útikalauz programozóknak
*/
public class WaitNotify {
static class IntQueue { // szinkronizált rutinok
  int row[]; // lista
  int first = 0, last = 0, num_of_elements = 0, row_length;

  public IntQueue(int row_length) {
    this.row_length = row_length;
    row = new int[row_length];
  }

  public synchronized void put(int value) {
    while ( num_of_elements == row_length ) {
      System.out.println(Thread.currentThread().getName() + " vár");
      try { wait(); } // ha nem tudunk írni, akkor várunk
      catch (InterruptedException e) {}
    }
    row[last] = value;
    last = (last + 1) % row_length;
    num_of_elements++;
    notify(); // megpróbáljuk a másik szálat felébreszteni
  }

  public synchronized int get() {
    while ( num_of_elements == 0 ) {
      System.out.println(Thread.currentThread().getName() + " vár");
      try { wait(); } // ha nem tudunk olvasni, akkor várunk
      catch (InterruptedException e) {}
    }
    first = (first + 1) % row_length;
    num_of_elements--;
    notify(); // megpróbáljuk a másik szálat felébreszteni
    return row[first];
  }
}

static class Producer extends Thread { // termelő
  IntQueue queue;
  int max_elements;

  public Producer(String name, IntQueue queue, int max_elements) {
    super(name);
    this.queue = queue;
    this.max_elements = max_elements;
  }

  public void run() { // termelés
    for (int i = 0; i < max_elements; ++i) {
      try {sleep((int)(Math.random() * 1000));}
      catch (InterruptedException e) {}
      int value = (int)(Math.random() * 10) + 1;
      queue.put(value);
      System.out.println( getName() + ":\t" + value);
    }
    queue.put(-1);
  }
}

static class Consumer extends Thread { // fogyasztó
  IntQueue queue;

  public Consumer(String name, IntQueue queue) {
    super(name);
    this.queue = queue;
  }

  public void run() { // fogyasztás, amíg van értelmes elem
    while (true) {
      try {sleep((int)(Math.random() * 1000));}
      catch (InterruptedException e) {}
      int value = queue.get();
      if (value == -1) break;
      System.out.println( getName() + ":\t" + value);
    }
  }
}

  public static void main(String s[]) {
    IntQueue queue = new IntQueue(5);
    Producer producer = new Producer("Termelő", queue, 15);
    Consumer consumer = new Consumer("Fogyasztó", queue);
    producer.start(); consumer.start();
  }

}