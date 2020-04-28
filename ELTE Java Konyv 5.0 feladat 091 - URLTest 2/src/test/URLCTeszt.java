package test;



import java.io.*;
import java.net.*;
import java.util.*;

/**
Egy URL-lel azonosított objektumról információk kiírása egy hozzá tartozó URLConnection objektum segítségével.
Ez az alkalmazás az argumentumában megadott URL-lel
azonosított objektumról információkat hoz le oly módon,
hogy létrehoz egy URLConnection kapcsolatot a megadott
objektummal, és sok mindent kiír.

@link.forrásfájl {@docRoot}/../data/http/src URLCTeszt.java
@link.letöltés {@docRoot}/../data/http URLCTeszt.jar
@since Java Útikalauz programozóknak
*/
public class URLCTeszt {
  public static void hasznalati_utasitas() {
      System.out.println("Használat: java URLCTeszt URL");
      System.exit(-1);
  }
  public static void URL_informaciok(String cim)
    throws MalformedURLException, IOException
  {
     URL url_objektum = new URL(cim);
     URLConnection url_kapcsolat = url_objektum.openConnection();
     System.out.println("URL : " + cim);
     System.out.println("  Tartalom típusa : " +
                             url_kapcsolat.getContentType());
     System.out.println("  Tartalom mérete : " +
                             url_kapcsolat.getContentLength());
     System.out.println("  Utolsó módosítás : " +
                             new Date(url_kapcsolat.getLastModified()));
     System.out.println("-------------------------------------------------");
     /* Most lapozva kiírjuk a tartalmat */
     BufferedReader tartalom = new BufferedReader(
                    new InputStreamReader(url_kapcsolat.getInputStream()));
     boolean fajlvege = false;
     int sorszam=4;
     BufferedReader input=new BufferedReader(new InputStreamReader(System.in));

     while ( !fajlvege ) {
       String egysor = tartalom.readLine();
       if (egysor == null) fajlvege=true; else
       System.out.println(egysor);
       sorszam++;
       if ((sorszam % 23) == 22) {
         System.out.println("A RETURN billentyű lenyomása lapoz!");
         input.readLine();
       }
     }
  }
  public static void main(String[] args) {
    if (args.length != 1) hasznalati_utasitas();
    try {
      URL_informaciok(args[0]);
    } catch (MalformedURLException e)
            { System.err.println("Hibás URL!"); }
      catch (IOException e)
            { System.err.println("Nem sikerült a letöltés!"); }
  }

}