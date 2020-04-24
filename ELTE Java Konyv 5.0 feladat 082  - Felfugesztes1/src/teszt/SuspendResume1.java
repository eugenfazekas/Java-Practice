package teszt;

/**
Felf�ggeszt�s.

@link.forr�sf�jl {@docRoot}/../data/thread/src SuspendResume1.java
@link.let�lt�s {@docRoot}/../data/thread SuspendResume1.jar
@since Java 2 �tikalauz programoz�knak
*/
public class SuspendResume1 extends Thread {
 volatile boolean threadSuspended;  // Igaz, ha a sz�l suspend �llapotba ker�l

 public void run() {
  for (int i = 0; i < 10; ++i) {
   System.out.println("Hell�, itt a " + getName() + "Thread" );
   try {
    sleep(500);                               // v�rakoz�s
    if (threadSuspended) {                    // Optimaliz�lva csak akkor
     synchronized(this) {                     // v�runk, ha suspend �llapot
      while (threadSuspended)                 // A wait miatt szinkroniz�lt
       wait();                                // blokkba ker�l
     }
    }
   } catch (InterruptedException e) {}        // A wait �s a sleep is azonos
  }                                           // kiv�telt eredm�nyez
  // egy�b tev�kenys�g...
 }

 public synchronized void mySuspend() {       // A v�ltoz� �rt�ke szerint
  if (!threadSuspended)                       // bekap. a susp. �llapotot
   System.out.println("Suspend " + getName());// az igazi v�rakoz�s a run()
   threadSuspended = true;                    // met�dusban van
 }

 public synchronized void myResume() {
  if (threadSuspended) {                      // Ha �ppen suspend �llapotban
   System.out.println("Resume " + getName());
   threadSuspended = false;                   // van, elengedj�k, ill. egy
   notify();                                  // jelz�st adunk, hogy resumed!
  }
 }

 static public void main(String args[]) {
  SuspendResume1 a, b;

  a = new SuspendResume1();                         // K�t sz�lat defini�lunk
  b = new SuspendResume1();
  System.out.println("Starting... ");
  a.start();                                  // �s ind�tunk el
  b.start();
                                              // V�runk egy kicsit, majd
  try { Thread.sleep(2000); } catch (InterruptedException e) {}
  a.mySuspend();                              // az egyiket felf�ggesztj�k
                                              // V�rjuk a hat�st, hogy csak
  try { Thread.sleep(1500); } catch (InterruptedException e) {}
                                              // a m�sik fut tov�bb
  a.myResume();                               // Majd ism�t elengedj�k
 }
}