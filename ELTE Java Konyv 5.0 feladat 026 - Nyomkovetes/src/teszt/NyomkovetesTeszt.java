package teszt;

/**
Klasszikus holtpont szituáció a futás közbeni hívási veremtartalom és
holtpontdetektáláshoz.

@see java.lang.Thread
@link.forrásfájl {@docRoot}/../data/programok/src NyomkovetesTeszt.java
@link.letöltés {@docRoot}/../data/programok NyomkovetesTeszt.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
class NyomkovetesTeszt extends Thread {

    /** Programszálak felügyeleti komponense */
    private static final java.lang.management.ThreadMXBean szálfelügyelet=
        java.lang.management.ManagementFactory.getThreadMXBean();

    /**
    Adott programszálban fellépő hiba hívási láncának megjelenítése.
    A programszál állapotinformációinak kiírása után a hívási szintek egyenkénti
    listája következik, a teljes lista alatt pedig a hívási lánc az eredeti
    formájában is megjelenik.

    @param programszál A hiba fellépésekor futó programszál.
    @param hiba A fellépett hibát reprezentáló objektum.
    */
    public static void hívásiLánc(Thread programszál, Throwable hiba) {
        System.out.print("\nNév: "+programszál.getName()+", démon: "+
            programszál.isDaemon()+", prioritás: "+programszál.getPriority()+
            ", azonosító: "+programszál.getId()+
            ", státusz: "+programszál.getState());             //szálinformációk
        java.lang.management.ThreadInfo szálinfó =
            szálfelügyelet.getThreadInfo(programszál.getId());
        String név = szálinfó.getLockName();               //monitor információk
        if (név!=null) System.out.print(", a kért zár: "+név);
        név = szálinfó.getLockOwnerName();
        if (név!=null) System.out.print(", a zár tulajdonosa: "+név+
            " (szálazonosító="+szálinfó.getLockOwnerId()+")");
        System.out.println();             //hívási lánc szintenkénti kilistázása
        for(StackTraceElement hívás:hiba.getStackTrace()) System.out.print("\t"+
            hívás.getClassName()+"."+hívás.getMethodName()+"("+(
            hívás.isNativeMethod() ? "natív kód" : (
            hívás.getFileName()==null?"ismeretlen forrás":(hívás.getFileName()+(
            hívás.getLineNumber()>0 ? (":"+hívás.getLineNumber()):""))))+")\n");
        hiba.printStackTrace();   //a hívási lánc eredeti formában megjelenítése
    }

    /**
    Adott programszál aktuális végrehajtási pontja hívási láncának kiírása.
    Az aktuális végrehajtási pont hívási láncát egy hibaobjektumba tároljuk el,
    és azt használjuk a megjelenítésre.

    @param programszál A megjelenítendő programszál.
    @param hívásilánc A programszál aktuális hívási lánca.
    */
    public static void hívásiLánc(Thread programszál,
                                  StackTraceElement[] hívásilánc) {
        if (hívásilánc == null||hívásilánc.length == 0) //a programszál aktuális
            hívásilánc = programszál.getStackTrace();      //végrehajtási pontja
        Throwable hiba = new Throwable("az eredeti hívási lánc");//becsomagolása
        hiba.setStackTrace(hívásilánc);                     //egy hibaobjektumba
        hívásiLánc(programszál, hiba);   //majd annak segítségével megjelenítjük
    }

    /** Teljes hívási lánc lista kiadása minden Java programszálról */
    public static void hívásiLáncLista() {
        System.out.println("Java programszálak hívási láncai "+         //fejléc
            System.getProperty("java.vm.name")+" ("+        //verzió információk
            System.getProperty("java.vm.version")+" "+
            System.getProperty("java.vm.info")+"):");
        java.util.Map<Thread, StackTraceElement[]> lista =      //az összes Java
            Thread.getAllStackTraces();   //programszál hívási láncának lekérése
        for (Thread programszál : lista.keySet())      //ée egymás utáni kiírása
            hívásiLánc(programszál, lista.get(programszál));
    }

    /** Nyomkövetést szabályozó konstans */
    private static final boolean NYOMKÖVETÉS = true;

    /** Holtpontlétrehozást vezérlő mutex, a {@link #számláló}t védi */
    private static final Object vezérlő = new Object();

    /** Holtpontszituációban résztvevő programszálak számlálója */
    private static int számláló;

    /** A másik programszál, melynek zárját meg kéne szerezni */
    private Thread másik;

    /**
    Konstruktor a programszál nevével.

    @param név A programszál neve, ezzel azonosítja magát az üzenetekben
    */
    private NyomkovetesTeszt(String név) {
        super(név);
    }

    /**
    A másik programszál megadása és a programszál elindítása.

    @param másik A másik programszál, melynek zárját meg kéne szerezni
    */
    private void holtpont(Thread másik) {
        this.másik = másik;
        start();
    }

    /**
    Programszál végrehajtása holtpontszituáció megvalósításával.
    Első lépésként a programszál saját magára megszerez egy objektumzárat, majd
    miután minden más résztvevő programszál is megtette ugyanezt, megpróbálja a
    másik résztvevő programszál zárját is megszerezni.
    */
    @Override
    public void run() {
        try {
            synchronized(this) {             //objektumzár a saját programszálra
                synchronized(vezérlő) {  //szinkronizálás a többi programszállal
                    számláló++; //résztvevő programszálak számlálójának növelése
                    vezérlő.wait();            //megvárjuk a többi programszálat
                }
                if (NYOMKÖVETÉS)//bájtkódutasítások nyomkövetésének bekapcsolása
                    Runtime.getRuntime().traceInstructions(true);
                synchronized(másik) {                    //másik zár megszerzése
                    System.out.println(getName()+": megvan mindkét zár???");
                }
            }
        } catch (Exception e) {                       //fellépett hiba kijelzése
            hívásiLánc(this, e);
        }
    }

    /**
    A tesztprogram indítása.
    A program paramétereként a holtpontszituációban résztvevő programszálak
    számát lehet megadni, ennek alapértelmezett értéke 2.

    @param argumentumok Az indításkor megadott paraméterek.
    */
    public static void main(String argumentumok[]) {
        if (NYOMKÖVETÉS)           //metódushívások nyomkövetésének bekapcsolása
            Runtime.getRuntime().traceMethodCalls(true);
        long kezdésms=System.currentTimeMillis(); //indulási időpont megjegyzése
        long kezdésnano=System.nanoTime();
        int szálszámláló = 2;             //alapértelmezés szerint 2 programszál
        if (argumentumok.length>0) try {     //programszálak számának beolvasása
            szálszámláló=Integer.parseInt(argumentumok[0]);
        } catch (Exception e) {}
        NyomkovetesTeszt elsőszál = null, másikszál = null;
        for (int számláló=1; számláló<=szálszámláló; számláló++) {  //résztvevők
            NyomkovetesTeszt programszál =                         //létrehozása
                new NyomkovetesTeszt("programszál"+számláló);
            if (másikszál==null) elsőszál = programszál;   //körkörös hivatkozás
            else másikszál.holtpont(programszál);                   //felépítése
            másikszál=programszál;
        }
        másikszál.holtpont(elsőszál);                 //hivatkozási kör bezárása
        while (true) {                       //megvárjuk minden szál elindulását
            synchronized(vezérlő) {      //ha már minde szál megszerezte a saját
                if (számláló==szálszámláló) {                   //objektumzárát,
                    vezérlő.notifyAll();             //megpróbálhatják a partner
                    break;                    //programszál zárát is megszerezni
                }
            }
            Thread.yield();              //várakozás a résztvevő programszálakra
        }
        hívásiLáncLista();   //kész a holtpont, lássuk a programszálak állapotát
        while(true) try {                           //percenként holptontkeresés
            long holtpontszálak[]=szálfelügyelet.findMonitorDeadlockedThreads();
            if (holtpontszálak!=null) {                     //holtpont kijelzése
                System.out.println("\nHoltpontban levő programszálak:");
                for (long szálazonosító:holtpontszálak) System.out.println("\t"+
                    szálfelügyelet.getThreadInfo(szálazonosító).getThreadName()+
                    " (szálazonosító="+szálazonosító+")");
            }               //eddigi futási időmérés eredményeinek megjelenítése
            System.out.println("\nFőprogramszál eddigi futási ideje: "+
                (System.currentTimeMillis()-kezdésms)+"ms ("+
                (System.nanoTime()-kezdésnano)+"ns)\n");
            sleep(60000);                           //következő percig várakozás
        } catch (Exception e) {
            hívásiLánc(Thread.currentThread(), e);    //fellépett hiba kijelzése
        }
    }
}