package teszt;

/**
Felfüggesztés.

@link.forrásfájl {@docRoot}/../data/thread/src SuspendResume1.java
@link.letöltés {@docRoot}/../data/thread SuspendResume1.jar
@since Java 2 Útikalauz programozóknak
*/
public class SuspendResume1 extends Thread {
 volatile boolean threadSuspended;  // Igaz, ha a szál suspend állapotba kerül

 public void run() {
  for (int i = 0; i < 10; ++i) {
   System.out.println("Helló, itt a " + getName() + "Thread" );
   try {
    sleep(500);                               // várakozás
    if (threadSuspended) {                    // Optimalizálva csak akkor
     synchronized(this) {                     // várunk, ha suspend állapot
      while (threadSuspended)                 // A wait miatt szinkronizált
       wait();                                // blokkba kerül
     }
    }
   } catch (InterruptedException e) {}        // A wait és a sleep is azonos
  }                                           // kivételt eredményez
  // egyéb tevékenység...
 }

 public synchronized void mySuspend() {       // A változó értéke szerint
  if (!threadSuspended)                       // bekap. a susp. állapotot
   System.out.println("Suspend " + getName());// az igazi várakozás a run()
   threadSuspended = true;                    // metódusban van
 }

 public synchronized void myResume() {
  if (threadSuspended) {                      // Ha éppen suspend állapotban
   System.out.println("Resume " + getName());
   threadSuspended = false;                   // van, elengedjük, ill. egy
   notify();                                  // jelzést adunk, hogy resumed!
  }
 }

 static public void main(String args[]) {
  SuspendResume1 a, b;

  a = new SuspendResume1();                         // Két szálat definiálunk
  b = new SuspendResume1();
  System.out.println("Starting... ");
  a.start();                                  // és indítunk el
  b.start();
                                              // Várunk egy kicsit, majd
  try { Thread.sleep(2000); } catch (InterruptedException e) {}
  a.mySuspend();                              // az egyiket felfüggesztjük
                                              // Várjuk a hatást, hogy csak
  try { Thread.sleep(1500); } catch (InterruptedException e) {}
                                              // a másik fut tovább
  a.myResume();                               // Majd ismét elengedjük
 }
}