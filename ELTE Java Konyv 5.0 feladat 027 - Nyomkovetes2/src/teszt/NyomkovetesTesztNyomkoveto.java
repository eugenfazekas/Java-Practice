package teszt;


/**
Egyszerű nyomkövető program a nyomkövetési tesztprogramunkhoz.
Fordításhoz és futtatáskor ne felejtsük el a {@code tools.jar}-t felvenni a
keresési útvonalba!

@see NyomkovetesTeszt
@see com.sun.jdi
@link.forrásfájl {@docRoot}/../data/programok/src NyomkovetesTesztNyomkoveto.java
@link.letöltés {@docRoot}/../data/programok NyomkovetesTesztNyomkoveto.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
class NyomkovetesTesztNyomkoveto extends Thread {

    /** A nyomkövetett kimenet */
    private final java.io.BufferedReader adatok;

    /** A nyomkövetett kimenetet azonosító kiírási prefix */
    private final String prefix;

    /** A nyomkövetett kimenet adatait megjelenítő kimenet */
    private final java.io.PrintStream kimenet;

    /**
    Konstruktor adott kimenet nyomkövetésére.

    @param kimenet Igaz értéke a standard-, hamis pedig a hibakimenet
        nyomkövetését írja elő.
    @param adatok A nyomkövetett adatkimenetre kiadott adatok.
    */
    NyomkovetesTesztNyomkoveto(boolean kimenet, java.io.InputStream adatok) {
        prefix = (kimenet ? "out" : "err")+">";              //prefix beállítása
        this.kimenet = kimenet ? System.out : System.err;   //kimenet beállítása
        this.adatok = new java.io.BufferedReader(    //adatok pufferelt szöveges
            new java.io.InputStreamReader(adatok) );                //beolvasása
        start();                                        //adatbeolvasás indítása
    }

    /**
    A nyomkövetett adatkimenetre kiadott adatok megjelenítése.
    Kilépés csak hiba esetén, vagy az adatcsatorna végének elérésekor.
    */
    @Override
    public void run() {
        while (true) try {
            String szöveg = adatok.readLine();    //egy sornyi szöveg kiolvasása
            if (szöveg==null) break;          //adatcsatorna vége esetén kilépés
            kimenet.println(prefix+szöveg);    //kiolvasott adatok megjelenítése
        } catch (Exception e) {                            //hiba esetén kilépés
            System.err.println("hiba: "+prefix+e.getLocalizedMessage());
            break;
        }
        try {                                            //adatcsatorna lezárása
            adatok.close();
        } catch (Exception e) {}
    }

    /**
    A nyomkövetés indítása.

    @param argumentumok Az indításkor megadott paraméterek.
    */
    public static void main(String argumentumok[]) {
        com.sun.jdi.VirtualMachineManager nyomkövetésvezérlő =//nyomkövetési API
            com.sun.jdi.Bootstrap.virtualMachineManager();       //belépési pont
        System.out.println("Nyomkövetési vezérlő verziója="+
            nyomkövetésvezérlő.majorInterfaceVersion()+"."+
            nyomkövetésvezérlő.minorInterfaceVersion());
        com.sun.jdi.connect.LaunchingConnector nyomkövetésikapcsolat = //szerver
            nyomkövetésvezérlő.defaultConnector();       //indítását mi végezzük
        System.out.println("Nyomkövetési kapcsolat="+nyomkövetésikapcsolat);
        java.util.Map<String, com.sun.jdi.connect.Connector.Argument>
            nyomkövetésiargumentumok = nyomkövetésikapcsolat.defaultArguments();
        com.sun.jdi.connect.Connector.Argument nyomkövetésiargumentum =
            nyomkövetésiargumentumok.get("main");   //indítandó program megadása
        nyomkövetésiargumentum.setValue(NyomkovetesTeszt.class.getName());
        com.sun.jdi.VirtualMachine nyomkövetés = null;
        try {                                     //nyomkövetett JVM létrehozása
            nyomkövetés=nyomkövetésikapcsolat.launch(nyomkövetésiargumentumok);
            System.out.println("Nyomkövetett JVM="+nyomkövetés.description());
            new NyomkovetesTesztNyomkoveto(true,         //standard kimenet meg-
                nyomkövetés.process().getInputStream());//jelenítésének indítása
            new NyomkovetesTesztNyomkoveto(false,    //standard hibakimenet meg-
                nyomkövetés.process().getErrorStream());//jelenítésének indítása
            nyomkövetés.resume();               //nyomkövetett program futtatása
            sleep(30000);
            nyomkövetés.suspend();                            //majd megállítása
            System.out.println("\nA nyomkövetett JVM programszálainak listája");
            for (com.sun.jdi.ThreadReference programszál :       //programszálak
                nyomkövetés.allThreads()) {
                System.out.println("\n"+programszál+                 //listázása
                    ", státusz="+programszál.status());
                for (com.sun.jdi.StackFrame hívás:programszál.frames()) //hívási
                    System.out.println("\t"+hívás.location());    //lánc kiírása
                if (programszál.currentContendedMonitor()!=null)  //kért monitor
                    System.out.println("\t- kért monitor: "+
                    programszál.currentContendedMonitor());
                for (com.sun.jdi.ObjectReference monitor : //birtokolt monitorok
                    programszál.ownedMonitors()) {
                    System.out.println("\t- birtokolt monitor: "+monitor);
                }
            }
            System.out.println();
            nyomkövetés.resume();    //nyomkövetett program futásának folytatása
            sleep(60000);
            nyomkövetés.exit(0);                      //majd végleges leállítása
            nyomkövetés = null;                      //befejeztük a nyomkövetést
        } catch (Exception e) {                       //hibaüzenet megjelenítése
            System.err.println("Hiba: "+e.getLocalizedMessage());
            e.printStackTrace();
        } finally {           //szükség esetén a nyomkövetési kapcsolat lezárása
            if (nyomkövetés!=null) nyomkövetés.dispose();
        }
    }
}