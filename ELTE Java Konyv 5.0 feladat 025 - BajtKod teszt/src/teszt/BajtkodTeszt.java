package teszt;



/**
A virtuális gép bájtkódkezelésének szemléltetése.
A program <EM>Java ügynökként</EM> ({@code -javaagent}), és/vagy alapértelmezett
rendszerszintű osztálybetöltőként ({@code -Djava.system.class.loader}) nyomon
követi a bájtkódfájlok betöltését.<P>
Paraméterként megadható bármely Java osztály teljes neve, ennek bájtkód
fájljáról (elhagyásakor a sajátjáról), valamint a csomagverziókról megjelenít
pár információt. Amennyiben a bájtkódfájlt egy Java archívum tartalmazza, ezen
archívum attribútumai és egyéb jellemzői is kilistázódnak.<P>
A program futása során a virtuális gép számára rendelkezésre álló memória
változásait is nyomon követhetjük.

@see java.lang.ClassLoader
@see java.lang.Package
@see java.lang.instrument
@see java.util.jar
@link.forrásfájl {@docRoot}/../data/programok/src BajtkodTeszt.java
@link.letöltés {@docRoot}/../data/programok BajtkodTeszt.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
public class BajtkodTeszt extends ClassLoader {

    /**
    Rendszerszintű osztálybetöltőt létrehozó konstruktor.

    @param eredeti Az eredeti rendszerszintű osztálybetöltő.
    */
    public BajtkodTeszt(ClassLoader eredeti) {
        super(eredeti);            //regisztrálás az osztálybetöltő hierarchiába
        System.out.println("[Rendszerszintű osztálybetöltő] eredeti: "+
            osztálybetöltőLista(eredeti));
    }

    /**
    Osztálybetöltő hierarchia kilistázása. A megadott kezdetitől egészen az ős
    betöltőig felsoroljuk a hierarchia elemeit {@code <} jelekkel elválasztva.

    @param betöltő A listázás kezdő pontja.
    @return A hierarchiát megjelenítő lista szöveges formában.
    */
    private static String osztálybetöltőLista(ClassLoader betöltő) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (betöltő==null) {                 //elértük az ős osztálybetöltőt
                sb.append("rendszerbetöltő (null)");
                break;
            }
            sb.append(betöltő.toString());
            sb.append(" < ");
            betöltő = betöltő.getParent();        //tovább felfelé a hierarchián
        }
        return sb.toString();
    }

    /**
    Adott nevű típus betöltése. Csak a betöltés tényét jelezzük, majd delegáljuk
    a feladatot.

    @param név A betöltendő típus neve.
    @param felold Előírja a betöltés után a hivatkozások feloldását.
    @return A betöltött típus reprezentációja.
    @throws ClassNotFoundException Amennyiben a kért típus nem található.
    */
    @Override
    protected Class loadClass(String név, boolean felold)
                                                 throws ClassNotFoundException {
        System.out.println("[Rendszerszintű osztálybetöltő] loadClass: "+név+
            ", felold: "+felold);    //a betöltés jelzése, majd tovább delegálás
        return super.loadClass(név, felold);
    }

    /**
    Adott nevű típus keresése. Csak a keresés tényét jelezzük, majd delegáljuk
    a feladatot.

    @param név A keresendő típus neve.
    @return A megtalált típus reprezentációja.
    @throws ClassNotFoundException Amennyiben a kért típus nem található.
    */
    @Override
    protected Class findClass(String név) throws ClassNotFoundException {
        System.out.println("[Rendszerszintű osztálybetöltő] findClass: "+név);
        return super.findClass(név); //a keresése jelzése, majd tovább delegálás
    }

    /**
    Adott nevű erőforrás keresése. Csak a keresés tényét jelezzük, majd
    delegáljuk a feladatot.

    @param név A keresendő erőforrás neve.
    @return A megtalált erőforrás elérése.
    */
    @Override
    public java.net.URL getResource(String név) {
        System.out.println("[Rendszerszintű osztálybetöltő] getResource: "+név);
        return super.getResource(név); //keresése jelzése, majd tovább delegálás
    }

/**Osztálybetöltés nyomkövetése bájtkódátalakítási lehetőség felhasználásával.*/
    private static class Atalakito implements
                                   java.lang.instrument.ClassFileTransformer {

        /** Alapértelmezett konstruktor elfedése. */
        private Atalakito() {}

        /**
        Új típus bájtkódjának betöltése után az átalakítás elvégzése. Mivel most
        csak a betöltés ténye érdekel minket, nem végzük semmiféle átalakítást.

        @param osztálybetöltő A betöltést végző osztálybetöltő.
        @param típusnév A frissen betöltött típus neve.
        @param újradefiniáltOsztály Típusreprezentáció felüldefiniálásakor az
        eredeti típus.
        @param védelmiTartomány Az osztálybetöltő működési biztonsági tartománya
        @param bájtkód Az eredetileg betöltött bájtkód.
        @return {@code null}, mert nem végzük semmiféle átalakítást.
        @throws java.lang.instrument.IllegalClassFormatException amennyiben a
        bejövő bájtkód nem szabályos.
        */
        public byte[] transform(ClassLoader osztálybetöltő, String típusnév,
               Class újradefiniáltOsztály,
               java.security.ProtectionDomain védelmiTartomány, byte[] bájtkód)
                       throws java.lang.instrument.IllegalClassFormatException {
            System.out.println("[Java ügynök] osztálybetöltés: "+ típusnév +
                ", betöltő: " + osztálybetöltőLista(osztálybetöltő));
            return null;                   //nem végeztünk semmiféle átalakítást
        }
    }

    /** Java ügynökök rendelkezésére álló környezet. */
    private static java.lang.instrument.Instrumentation ügynökség;

    /**
    Indítás Java ügynökként.

    @param opciók Az ügynök indításakor megadott opciók.
    @param ügynök Az ügynök rendelkezésére álló környezet.
    */
    public static void premain(String opciók,
                               java.lang.instrument.Instrumentation ügynök) {
        ügynökség = ügynök;                               //környezet eltárolása
        ügynökség.addTransformer(new Atalakito());  //kódátalakító regisztrálása
    }

    /**
    A tesztprogram indítása.

    @param argumentumok Az indításkor megadott paraméterek.
    */
    public static void main(String[] argumentumok) {
        memória("Kezdeti állapot");       //kezdeti memóriaállapot megjelenítése
        Object objektum = ClassLoader.getSystemClassLoader();   //rendszerszintű
        if (!(objektum instanceof BajtkodTeszt)) {  //osztálybetöltő ellenőrzése
          System.err.println("\nNem történt meg a rendszerszintű osztálybetöltő"
              +" beállítása!\nEhhez adja meg a következő rendszerjellemzőt:\n"
              +"-Djava.system.class.loader="+BajtkodTeszt.class.getName()+"\n");
          objektum = null;
        }
        if (ügynökség==null)          //Java ügynökként való indítás ellenőrzése
            System.err.println("\nA futtatás nem Java ügynökként folyik!\n"+
            "Ehhez adja meg a következő futtató opciót:\n"+
            "-javaagent:BajtkodTeszt.jar\n");

        String típusnév = null;                  //a vizsgálni kívánt típus neve
        if (argumentumok.length > 0) {
            típusnév = argumentumok[0];       //paraméterként történt a megadása
            objektum = null;
        } else típusnév = BajtkodTeszt.class.getName();    //különben saját maga
        try {
            Class típus = Class.forName(típusnév);           //a típus betöltése
            if (ügynökség!=null) {              //elfoglalt tárméretek kijelzése
                System.out.println("Típus mérete: "+
                    ügynökség.getObjectSize(típus));
                try {                                            //példányosítás
                    if (objektum==null) objektum=típus.newInstance();
                    System.out.println("A típus egy példányának mérete: "+
                        ügynökség.getObjectSize(objektum));
                } catch (Throwable t) {       //példányosításkor hiba lépett fel
                    System.err.println("Nem sikerült a példányosítás: "+t);
                }
            }
                                                  //osztálybetöltő megjelenítése
            ClassLoader betöltő = típus.getClassLoader();
            System.out.println("Osztálybetöltő: "+osztálybetöltőLista(betöltő));
            if (betöltő==null)          //az ős betöltő helyett a rendszerszintű
                betöltő = ClassLoader.getSystemClassLoader();       //használata
            java.net.URLConnection elérés = betöltő.getResource(   //bájtkódfájl
                típusnév.replace('.', '/')+".class").openConnection();
            System.out.println("A bájtkódfájl helye: " + elérés.getURL());
            java.io.DataInputStream bájtkódfájl =                   //megnyitása
                new java.io.DataInputStream(elérés.getInputStream());
            int kezdet = bájtkódfájl.readInt();         //első 4 bájt beolvasása
            int alverzió = bájtkódfájl.readUnsignedShort();     //további 2 bájt
            int főverzió = bájtkódfájl.readUnsignedShort();     //további 2 bájt
            byte[] buffer = new byte[1024];//a teljes bájtkódfájl végigolvasása,
            int számláló = 0;//mert csak ekkor tudja a rendszer a digitális alá-
            while (számláló>=0) számláló = bájtkódfájl.read(buffer);  //írásokat
            bájtkódfájl.close();                                  //ellenőrizni!
            System.out.println("Kezdőbájtok: "+Integer.toHexString(kezdet));
            System.out.println("Verzió: "+főverzió+"."+alverzió);

            Package csomag = típus.getPackage();
            if (csomag!=null) {         //csomag verzióinformációk megjelenítése
                System.out.println("Csomag: "+csomag.getName()+
                    " ("+(csomag.isSealed()?"":"nem ")+"lezárt)");
                System.out.println("\tSpecifikáció megnevezése: "+
                    csomag.getSpecificationTitle());
                System.out.println("\tSpecifikáció létrehozója: "+
                    csomag.getSpecificationVendor());
                System.out.println("\tSpecifikáció verziószáma: "+
                    csomag.getSpecificationVersion());
                System.out.println("\tMegvalósítás megnevezése: "+
                    csomag.getImplementationTitle());
                System.out.println("\tMegvalósítás létrehozója: "+
                    csomag.getImplementationVendor());
                System.out.println("\tMegvalósítás verziószáma: "+
                    csomag.getImplementationVersion());
            }//Java archívumba csomagolt bájtkód esetén az archívum jellemzőinek
                                                                   //kilistázása
            if (elérés instanceof java.net.JarURLConnection) {
                java.net.JarURLConnection jar=(java.net.JarURLConnection)elérés;
                java.util.jar.Attributes  attribútumok=jar.getMainAttributes();
                if (attribútumok != null) {          //fő leírófájl fő szekciója
                    System.out.println("Jar attribútumok:");
                    String[] nevek=new String[attribútumok.keySet().size()];
                    int index=0;          //attribútumok rendezése nevük alapján
                    for (Object attribútumnév : attribútumok.keySet())
                        nevek[index++]=attribútumnév.toString();
                    java.util.Arrays.sort(nevek);
                    for ( String név : nevek ) System.out.println(//attribútumok
                        "\t"+név+": "+attribútumok.getValue(név));   //listázása
                }
                java.util.jar.JarEntry jarbejegyzés = jar.getJarEntry();
                attribútumok = jarbejegyzés.getAttributes();
                if (attribútumok != null) {                     //egyedi szekció
                    System.out.println("Jarbejegyzés attribútumok:");
                    String[] nevek=new String[attribútumok.keySet().size()];
                    int index=0;          //attribútumok rendezése nevük alapján
                    for (Object attribútumnév : attribútumok.keySet())
                        nevek[index++]=attribútumnév.toString();
                    java.util.Arrays.sort(nevek);
                    for ( String név : nevek ) System.out.println(//attribútumok
                        "\t"+név+": "+attribútumok.getValue(név));   //listázása
                }
                if (jarbejegyzés.getCertificates()!=null) {
                    System.out.println("Jarbejegyzés tanúsítványok:");
                    for ( java.security.cert.Certificate tanúsítvány :
                        jarbejegyzés.getCertificates() ) //egyedi tanúsítványok
                            System.out.println("\t"+tanúsítvány);   //listázása
                }
                if (jarbejegyzés.getCodeSigners()!=null) {
                    System.out.println("Jarbejegyzés aláírók:");
                    for ( java.security.CodeSigner aláíró :
                        jarbejegyzés.getCodeSigners() )         //egyedi aláírók
                            System.out.println("\t"+aláíró);         //listázása
                }
                System.out.println("Bájtkódfájl becsomagolt / eredeti mérete: "+
                 jarbejegyzés.getCompressedSize()+" / "+jarbejegyzés.getSize());

            }
        } catch (Exception e) {                                    //hibakezelés
            System.err.println("Hiba: "+e);
        }
        memória("Végállapot");   //befejezés előtti memóriaállapot megjelenítése
        System.gc();                               //szemétgyűjtés elvégeztetése
        memória("Szemétgyüjtés után");//majd a memóriaállapot újra megjelenítése
    }

    /**
    A virtuális gép aktuális memóriaállapotának megjelenítése.

    @param szöveg A jelentést bevezető szöveg.
    */
    private static void memória(String szöveg) {
        long szabad = Runtime.getRuntime().freeMemory();   //értékek lekérdezése
        long össz = Runtime.getRuntime().totalMemory();
        long maximum = Runtime.getRuntime().maxMemory();
        System.out.println(szöveg+": "+szabad+" szabad, "+össz+" össz, "+maximum
            +" maximum memória");                             //és megjelenítése
    }
}