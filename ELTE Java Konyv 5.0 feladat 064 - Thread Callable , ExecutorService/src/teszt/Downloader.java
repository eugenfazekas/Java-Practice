package teszt;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
Korlátozott számú szállal letöltő példaprogram.

@link.forrásfájl {@docRoot}/../data/thread/src Downloader.java
@link.letöltés {@docRoot}/../data/thread Downloader.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
public class Downloader implements Callable<String> {
  String spec; // letöltendő fájl neve
  public Downloader(String spec) {
    this.spec = spec;
  }
  public String call() {
    try {
      java.net.URL url = new java.net.URL(spec); // URL forrás hivatkozás
      InputStream input = url.openStream();
      String filename = url.getPath(); // lokális cél fájl
      File file = new File(filename.substring(filename.lastIndexOf('/') + 1));
      OutputStream output = new FileOutputStream(file);
      byte[] buffer = new byte[1024]; // 1kb-os átmeneti tároló
      int length;
      while ((length=input.read(buffer))!= -1) output.write(buffer, 0, length);
    } catch (IOException e) {
      return "A letöltés sikertelen: " + spec;
    }
    return "A letöltés sikeres: " + spec;
  }
  public static void main(String[] args) {
    ExecutorService executor=Executors.newFixedThreadPool(16);//16szálas futtató
    ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
    // Elindítjuk a feladatokat.
    for (String url : args) futures.add(executor.submit(new Downloader(url)));
    executor.shutdown(); // A futtató nem vár több feladatot
    for (Future<String> future : futures) try {// Megvárjuk a folyamatok végét
        System.out.println(future.get());
    } catch (ExecutionException e) {
    } catch (InterruptedException e) {}
  }
}