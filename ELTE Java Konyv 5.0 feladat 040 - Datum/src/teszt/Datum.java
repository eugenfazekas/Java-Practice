package teszt;

import java.util.*;

/**
Dátumkezelési példa.

@link.forrásfájl {@docRoot}/../data/util/src Datum.java
@link.letöltés {@docRoot}/../data/util Datum.jar
@since Java 2 Útikalauz programozóknak
*/
class Datum {
  public static void main(String[] args) {
    // Melyik időzónák is jók nekünk, magyaroknak? (1 óra Greenwich-től)
    String[] jók=TimeZone.getAvailableIDs(1*60*60*1000);
    System.out.println("Greenwich-től keletre 1 órányira levő időzónák:");
    for(int i=0;i<jók.length;i++)
      System.out.println("    " + jók[i]);
    // Vesszük azt, amit hivatalosan használunk:
    SimpleTimeZone ect = new SimpleTimeZone(1,"ECT");
    // Beállítjuk a nyári időszámítás kezdetét április első vasárnapjára,
    // hajnal 2 órára
    ect.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2*60*60*1000);
    // ... és a végét október utolsó vasárnapjára, szintén 2 órára.
    ect.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2*60*60*1000);

    // Ezzel az időzónával kezdünk egy időszámítást:
    Calendar calendar = new GregorianCalendar(ect);
    // Az aktuális időpillanatot lekérdezzük
    Date Most = new Date();

    calendar.setTime(Most);
    System.out.println("Az aktuális idő:");
    System.out.print(calendar.get(Calendar.ERA)==0 ? "i.e. " : "i.sz. ");
    System.out.print(calendar.get(Calendar.YEAR) + ".");
    System.out.print((calendar.get(Calendar.MONTH)+1) + ".");
    System.out.print(calendar.get(Calendar.DATE) + " ");
    System.out.print(calendar.get(Calendar.AM_PM)==1?"du ":"de ");
    System.out.print((calendar.get(Calendar.HOUR)+1) + ":");
    System.out.print(calendar.get(Calendar.MINUTE) + ":");
    System.out.print(calendar.get(Calendar.SECOND) + " mp. ");
    System.out.println(calendar.get(Calendar.MILLISECOND) + " ezredmp.");

    System.out.print("Most az év " + calendar.get(Calendar.WEEK_OF_YEAR) +
		     ". hetében járunk, ");
    System.out.println("Ez egyébként a(z) "+
       calendar.get(Calendar.WEEK_OF_MONTH) + ". ebben a hónapban.");
  }
}
