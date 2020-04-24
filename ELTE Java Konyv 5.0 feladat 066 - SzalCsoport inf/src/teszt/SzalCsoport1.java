package teszt;

class SzalCsoport1 extends Thread {
	  SzalCsoport1(String name) {  super(name); }        // nev�t is elt�roljuk
	  public void run() {                            // nem csin�l semmi
	    try {                                        // k�l�n�set
	      for (int i=0; i<5; i++) {
	        sleep(100);
	      }
	    } catch (InterruptedException e) {}
	  }

	  public static void main(String args[]) {
	    SzalCsoport1[] threads = new SzalCsoport1[15];     // a l�trehozand� sz�lak

	    for (int i = 0; i < 15; ++i) {             // mindet install�ljuk,
	      threads[i] = new SzalCsoport1(i +  ". sz�l");
	    }
	    for (int i = 0; i < 5; ++i) {              // de csak 5-�t ind�tunk el
	      threads[2*i].start();
	    }

	    ThreadGroup group = Thread.currentThread().getThreadGroup();
	    int estNum = group.activeCount();          // aktivak szama
	    Thread[] active = new Thread[estNum];      // referenci�khoz
	    int actNum = group.enumerate(active);      // aktivak lek�rdez�se �s
	                                               // megsz�ml�l�sa
	    System.out.println("Nyomk�vet�si info:");  // a nyomk�vet�si lista
	    group.list();                              // ki�r�sa
	    System.out.println("Csoport N�v: " + group.getName());
	    System.out.println("Fut�k #: " + actNum);
	    System.out.println("Fut�k list�ja");

	    for (int i = 0; i < actNum; ++i)
	      System.out.println("\t" + i +". sz�l: " + active[i].getName());
	  }
	}