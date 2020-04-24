package teszt;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
Felfüggesztési példa.
<P align="center"><APPLET code="elte.java2_utikalauz5.thread.SuspendResume2.class"
archive="{@docRoot}/../data/thread/SuspendResume2.jar" width=200 height=200></APPLET></P>

@link.forrásfájl {@docRoot}/../data/thread/src SuspendResume2.java
@link.letöltés {@docRoot}/../data/thread SuspendResume2.jar
@since Java 2 Útikalauz programozóknak
*/
public class SuspendResume2 extends Applet implements Runnable, MouseListener {
    /** Verziószám. */
    private final static long serialVersionUID = 15L;

  int cnt = 0;                      // a karikán melyik pont piros aktuálisan
  Thread runner = null;             // a szál, amelyik a pontokat rajzolja
  volatile boolean threadSuspended; // felfüggesztett-e a szál (egér miatt)

  public void init() {
    threadSuspended = false;
    setFont(new Font("TimesRoman", Font.BOLD, 12));  // a szöveg kiíráshoz
    addMouseListener(this);                  // egér kezelése miatt
  }

  public void destroy() {                    // befejezésnél az egér-
    removeMouseListener(this);               // kezelő leállítása
  }

  public void start() {
    runner = new Thread(this);               // Az applet indításakor a
    runner.start();                          // szálat is elindítjuk
  }

  public synchronized void stop() {          // Az applet leállításakor a
    runner = null;                           // szálnak stop jelzés
    if (threadSuspended) {                   // Ha éppen felfüggesztett
      threadSuspended = false;               // volt, akkor elengedjük
      notify();
    }
  }

  public void run() {
    while (runner == Thread.currentThread()) {  // Amíg a szál él,
      try {                                     // addig fut a run() metódus
        Thread.sleep(200);
        if (threadSuspended)                    // Ha felfüggesztett,
         synchronized(this) {
          while (threadSuspended) {             // akkor vár, amíg el nem
            wait();                             // eresztik
          }
         }
      } catch (InterruptedException e){
      }
      repaint();                                // kirajzoljuk az appletet
    }
  }

  public void paint(Graphics g) {
   g.drawString( "Nyomd meg az egérgombot", 35, 180); // Szöveg
   for (int i = 0; i < 12; ++i) {
    if (i == cnt) g.setColor(Color.red);       // az aktuális piros
    else g.setColor(Color.blue);               // amúgy kék pontok
    g.fillOval( (int) (100 + 50 * Math.sin((double) i / 6 * Math.PI)),
          (int) (100 - 50 * Math.cos((double) i / 6 * Math.PI)),
          10,10);                              // a szines pont kirajzolása
   }                                           // egy karika mentén
   cnt = ++cnt % 12;                           // legyen a köv. pont az akt.
  }

  // ha megnyomták az egér fülét
  public synchronized void mousePressed(MouseEvent e) {
    e.consume();                               // váltunk a felfüggesztés
    threadSuspended = !threadSuspended;        // állapotán
    if (!threadSuspended)                      // ha eddig felfügg. volt
      notify();                                // akkor most eleresztjük
  }

  public void mouseReleased(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
  public void mouseClicked(MouseEvent e) { }

  public String getAppletInfo() {
    return "Title: SuspendResume2\nSuspend/Resume.";
  }
}