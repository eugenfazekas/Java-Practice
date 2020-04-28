package test;

import java.io.*;
import java.net.*;

/**
Egy URL-lel azonosított objektum letöltése a hálózatról.
Ez az alkalmazás letölt egy, az első és egyetlen argumentumában megadott URL-lel azonosított objektumot.

@link.forrásfájl {@docRoot}/../data/http/src URLTeszt.java
@link.letöltés {@docRoot}/../data/http URLTeszt.jar
@since Java Útikalauz programozóknak
*/
public class URLTeszt {

  public static void hasznalati_utasitas() {
      System.out.println("Használat: java URLTeszt URL");
      System.exit(-1);
  }

  public static Object kinyeri_az_adatot_az_URL_bol(String cim)
    throws MalformedURLException, IOException
  {
     URL url_objektum = new URL(cim);
     return url_objektum.getContent();
  }

  public static void main(String[] args) {
    if (args.length != 1) hasznalati_utasitas();
    Object obj = "Nincs mit kiirnom ..";
    try {
      obj=kinyeri_az_adatot_az_URL_bol(args[0]);
    } catch (MalformedURLException e)
            { System.err.println("Hibás URL!"); }
      catch (IOException e)
            { System.err.println("Nem sikerült a letöltés!"); }

    try {
      System.out.println((String)obj);
    } catch (ClassCastException e) {
            if (obj instanceof InputStream) {
             try {
              BufferedReader tartalom = new BufferedReader
                                          (new InputStreamReader
                                              ((InputStream)(obj)));
              boolean fajlvege=false;
              while (!fajlvege) {
                String egysor = tartalom.readLine();
                if (egysor==null) { fajlvege = true; }
                  else
                { System.out.println(egysor); }
              }
             } catch (IOException ie) {
               System.out.println("Hiba történt a tartalom letöltésekor!");
             }
            } else {
               System.out.println("Nem sikerült a tartalom kiírható"+
                                  " formára konvertálása!");
               System.out.println("A kapott objektum osztálya:");
               System.out.println(obj.toString());
            }
      }
  }
}