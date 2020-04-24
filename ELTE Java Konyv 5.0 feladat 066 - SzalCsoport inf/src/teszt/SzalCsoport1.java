package teszt;

class SzalCsoport1 extends Thread {
	  SzalCsoport1(String name) {  super(name); }        // nevét is eltároljuk
	  public void run() {                            // nem csinál semmi
	    try {                                        // különöset
	      for (int i=0; i<5; i++) {
	        sleep(100);
	      }
	    } catch (InterruptedException e) {}
	  }

	  public static void main(String args[]) {
	    SzalCsoport1[] threads = new SzalCsoport1[15];     // a létrehozandó szálak

	    for (int i = 0; i < 15; ++i) {             // mindet installáljuk,
	      threads[i] = new SzalCsoport1(i +  ". szál");
	    }
	    for (int i = 0; i < 5; ++i) {              // de csak 5-öt indítunk el
	      threads[2*i].start();
	    }

	    ThreadGroup group = Thread.currentThread().getThreadGroup();
	    int estNum = group.activeCount();          // aktivak szama
	    Thread[] active = new Thread[estNum];      // referenciákhoz
	    int actNum = group.enumerate(active);      // aktivak lekérdezése és
	                                               // megszámlálása
	    System.out.println("Nyomkövetési info:");  // a nyomkövetési lista
	    group.list();                              // kiírása
	    System.out.println("Csoport Név: " + group.getName());
	    System.out.println("Futók #: " + actNum);
	    System.out.println("Futók listája");

	    for (int i = 0; i < actNum; ++i)
	      System.out.println("\t" + i +". szál: " + active[i].getName());
	  }
	}