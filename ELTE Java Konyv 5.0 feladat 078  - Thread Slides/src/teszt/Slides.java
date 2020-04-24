package teszt;



import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

/**
Példa szál terminálás megvárására.
Képeket vetítő program, indítási paraméterekként a képnevekkel, például:
{@code Slides 0.gif 1.gif 2.gif 3.gif 4.gif 5.gif 6.gif 7.gif 8.gif 9.gif}

@link.forrásfájl {@docRoot}/../data/thread/src Slides.java
@link.letöltés {@docRoot}/../data/thread Slides.jar
@since Java 2 Útikalauz programozóknak
*/
public class Slides {
  // a betöltött képre referencia
  private BufferedImage load;

  // A "load" bufferbe kép betöltő.
  private class ImageLoader implements Runnable {
    private String filename;

    public ImageLoader(String filename) {
      this.filename = filename;
    }

    public void run() {
      try {
        load = ImageIO.read(getClass().getClassLoader().getResource(filename));
      } catch (IOException e) {
        load = null;
      }
    }
  }

  public Slides(String filenames[]) {
    JFrame frame = new JFrame("Slides");
    JLabel label = new JLabel();
    frame.setSize(640, 480);
    frame.getContentPane().add(label);
    frame.setVisible(true);
    Thread loader = new Thread(new ImageLoader(filenames[0]));
    loader.start();
    for (int i = 1; i < filenames.length; ++i) {
      try {            // csak akkor jelenítjük meg a képet,
        loader.join(); // ha az már be van töltve
      } catch (InterruptedException e) {}
      label.setIcon(load != null ? new ImageIcon(load) : null);
      loader = new Thread(new ImageLoader(filenames[i]));
      loader.start(); // új betöltés indítása
      try {
        Thread.sleep(2000); // várakozás
      } catch (InterruptedException e) {}
    }
    try {
      loader.join();
    } catch (InterruptedException e) {}
    label.setIcon(load != null ? new ImageIcon(load) : null);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {}
    System.exit(0);
  }

  public static void main(String args[]) {
    new Slides(args);
  }
}