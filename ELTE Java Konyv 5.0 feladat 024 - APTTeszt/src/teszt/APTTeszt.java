package teszt;


//generálásvezérlő értékek
import static teszt.ImplGeneralas.*;

/**
Üres interfészimplementáció generálása annotációk alapján.
A program az {@link ImplGeneralas} annotáció feldolgozójaként (és egyben ehhez
gyárként) használható az <A href="http://java.sun.com/j2se/1.5.0/docs/guide/apt"
target=_blank>{@code apt}</A> segédprogram alkalmazásakor.

@link.forrásfájl {@docRoot}/../data/programok/src APTTeszt.java
@link.letöltés {@docRoot}/../data/programok APTTeszt.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
public class APTTeszt implements
com.sun.mirror.apt.AnnotationProcessorFactory,           //feldolgozógyár
com.sun.mirror.apt.AnnotationProcessor,            //annotáció feldolgozó
com.sun.mirror.apt.RoundCompleteListener {             //apt menetfigyelő

/** Publikus alapértelmezett konstruktor. Ezt hívja meg az {@code apt}. */
public APTTeszt() {}

/**
Visszaadja a kezelt annotációk leírását.
Ez a típus neve, vagy a tetszőleges annotációt jelölő {@code *} lehet.

@return A feldolgozni kívánt annotációk leírásainak listája.
*/
public java.util.Collection<String> supportedAnnotationTypes() {
return java.util.Arrays.asList(
"elte.java2_utikalauz5.programok.ImplGeneralas",
"elte.java2_utikalauz5.programok.ImplGeneralas.Return");
}

/**
Egyszerű fájlnévgenerálást előíró kapcsoló. Megadásakor a generált
forrásfájl nem kerül bele a csomaghierarchiát követő alkönyvtárba.
*/
private static final String OPCIÓ = "-Asimple";

/**
Visszaadja a kezelt opciók listáját.

@return A feldolgozni kívánt opciók neveinek listája.
*/
public java.util.Collection<String> supportedOptions() {
return java.util.Arrays.asList(OPCIÓ);
}

/**
Az aktuális menet annotációit kezelő objektumot legyártó metódus.

@param atd Az aktuális menetben talált annotációk.
@param menet Az aktuális menetet reprezentáló objektum.
@return Az aktuális menet annotációit kezelő objektum.
*/
public com.sun.mirror.apt.AnnotationProcessor getProcessorFor(
java.util.Set<com.sun.mirror.declaration.AnnotationTypeDeclaration> atd,
com.sun.mirror.apt.AnnotationProcessorEnvironment menet) {
this.menet=menet;                    //környezetleíró objektum elmentése
menet.addListener(this);                    //menetfigyelő regisztrálása
return this;           //feldolgozó objektum azonos a gyártó objektummal
}

/**
Az aktuális menetet reprezentáló objektum tárolóhelye. Beállítása a gyártó,
felhasználása pedig az annotációkat kezelő metódusban történik.
*/
private com.sun.mirror.apt.AnnotationProcessorEnvironment menet;

/** Az aktuális menet annotációinak feldolgozása. */
public void process() {
for (com.sun.mirror.declaration.TypeDeclaration  interfész :
(com.sun.mirror.util.DeclarationFilter.getFilter( //csak interfészek
com.sun.mirror.declaration.InterfaceDeclaration.class). //kellenek
and(com.sun.mirror.util.DeclarationFilter.getFilter(
com.sun.mirror.declaration.AnnotationTypeDeclaration.class).not(
))).filter(menet.getSpecifiedTypeDeclarations())) {
ImplGeneralas genimp = interfész.getAnnotation(ImplGeneralas.class);
if (genimp==null)             //csomagszintű alapértelmezés átvétele
genimp=interfész.getPackage().getAnnotation(ImplGeneralas.class);
if (genimp==null || Mod.NEM_KELL.equals(genimp.value()))
continue;                                   //nem kell generálni
boolean kell_default =    //Return annotáció figyelmen kívűl hagyása
genimp!=null && Mod.KELL_DEFAULT.equals(genimp.value());
String forrásfájlnév = fájlnévGenerálás(  //forrásfájlnév generálása
menet.getOptions().containsKey(OPCIÓ) ?
interfész.getSimpleName() : interfész.getQualifiedName());
osztályGenerálás(forrásfájlnév, kell_default, interfész);//generálás
}
}

/**
A megvalósító osztály nevének generálása.

@param interfész A megvalósítandó interfész neve
@return Az interfészt megvalósító osztály generált neve
*/
private static String fájlnévGenerálás( String interfész ) {
return interfész+"Impl";
}

/**
Üres interfészimplementáló osztály generálása.

@param forrásfájlnév A létrehozandó fájl neve.
@param kell_default A Return annotáció figyelmen kívűl hagyását írja elő.
@param interfész Az aktuális interfész típusdeklarációja.
*/
private void osztályGenerálás(String forrásfájlnév, boolean kell_default,
com.sun.mirror.declaration.TypeDeclaration interfész) {
menet.getMessager().printNotice(forrásfájlnév+" generálása...");
java.io.PrintWriter forrásfájl = null;
try {                                  //generált forrásfájl létrehozása
forrásfájl = menet.getFiler().createSourceFile(forrásfájlnév);
forrásfájl.print("package ");                      //csomag megadása
forrásfájl.print(interfész.getPackage().getQualifiedName());
forrásfájl.println(";");
forrásfájl.println();
forrásfájl.println("/**");    //dokumentációs megjegyzés létrehozása
forrásfájl.print("Generált üres implementáció az ");
forrásfájl.print(interfész.getQualifiedName());
forrásfájl.println(" interfészhez.");
if (interfész.getDocComment()!=null) {    //interfészleírás átvétele
forrásfájl.print("<P><B>A megvalósított interfész leírása:</B>");
forrásfájl.print("<BR>"+interfész.getDocComment());
}
forrásfájl.println("*/");
if (interfész.getModifiers().contains( //az interfész láthatóságának
com.sun.mirror.declaration.Modifier.PUBLIC))          //átvétele
forrásfájl.print("public ");
forrásfájl.print("class ");    //az implementáló osztály létrehozása
forrásfájl.print(fájlnévGenerálás(interfész.getSimpleName()));
forrásfájl.print(" implements "); //interészmegvalósítás jelzése
forrásfájl.print(interfész.getSimpleName());
forrásfájl.println(" {");
forrásfájl.println("\t/** Alaplértelmezett üres konstruktor */");
forrásfájl.print("\t public ");             //konstruktor generálása
forrásfájl.print(fájlnévGenerálás(interfész.getSimpleName()));
forrásfájl.println("() {}");
metódusGenerálás(forrásfájl, kell_default, interfész);
forrásfájl.println("}");
} catch (java.io.IOException ioe) {
menet.getMessager().printError(ioe.getLocalizedMessage());    //hiba
} finally {
if (forrásfájl != null) forrásfájl.close(); //fájlgenerálás lezárása
}
}

/**
Üres interfészimplementáció metódusainak generálása.

@param forrásfájl A létrehozott forrásfájl szöveggenerátora.
@param kell_default A Return annotáció figyelmen kívűl hagyását írja elő.
@param interfész Az aktuális interfész típusdeklarációja.
*/
private void metódusGenerálás(java.io.PrintWriter forrásfájl,
boolean kell_default, com.sun.mirror.declaration.TypeDeclaration interfész){
for (com.sun.mirror.type.InterfaceType sit :  //a kibővitett interfészek
interfész.getSuperinterfaces())        //metódusainak generálása
metódusGenerálás(forrásfájl, kell_default, sit.getDeclaration());
for (com.sun.mirror.declaration.MethodDeclaration metódus :  //metódusok
interfész.getMethods()) {                           //generálása
forrásfájl.println();
forrásfájl.print("\tpublic ");
boolean első=true;
for (com.sun.mirror.declaration.TypeParameterDeclaration típusnév :
metódus.getFormalTypeParameters()) {    //generic típusnevek
if (első) első=false;
else forrásfájl.print(", ");  //több típusparaméter elválasztása
forrásfájl.print("<");
forrásfájl.print(típusnév);
forrásfájl.print(">");
}
if (!első) {
első=true;
forrásfájl.print(" ");
}
forrásfájl.print(metódus.getReturnType());      //visszatérési típus
forrásfájl.print(" ");
forrásfájl.print(metódus.getSimpleName());              //metódusnév
forrásfájl.print("(");
java.util.Iterator<com.sun.mirror.declaration.ParameterDeclaration>
paraméterek=metódus.getParameters().iterator();
while (paraméterek.hasNext()) {               //formális paraméterek
com.sun.mirror.declaration.ParameterDeclaration paraméter =
paraméterek.next();
if (paraméterek.hasNext()) {    //közbenső paraméterek kiiratása
forrásfájl.print(paraméter);
forrásfájl.print(", ");
} else if (metódus.isVarArgs()) {       //kötetlen paraméterszám
forrásfájl.print(((com.sun.mirror.type.ArrayType) //jelölése
paraméter.getType()).getComponentType());
forrásfájl.print("... ");
forrásfájl.print(paraméter.getSimpleName());
} else forrásfájl.print(paraméter); //utolsó paraméter kiiratása
}
forrásfájl.print(")");
for (com.sun.mirror.type.ReferenceType kivétel :       //ellenőrzött
metódus.getThrownTypes()) {            //kivételek listázása
if (első) {
forrásfájl.print(" throws ");
első=false;
} else forrásfájl.print(", ");
forrásfájl.print(kivétel);
}
forrásfájl.println(" {");
if (!(metódus.getReturnType() instanceof      //visszatérési értékek
com.sun.mirror.type.VoidType)) {                //generálása
forrásfájl.print("\t\treturn ");
ImplGeneralas.Return annotáció = //Return annotáció kiértékelése
metódus.getAnnotation(ImplGeneralas.Return.class);
if (!kell_default && annotáció!=null)         //Return annotáció
forrásfájl.print(annotáció.value());         //felhasználása
else if (metódus.getReturnType() instanceof   //primitív típusok
com.sun.mirror.type.PrimitiveType) {  //alapértelmezett
switch (((com.sun.mirror.type.PrimitiveType)       //értékei
metódus.getReturnType()).getKind()) {
case BOOLEAN: forrásfájl.print("false"); break;
case CHAR: forrásfájl.print("'\\u0000'"); break;
default: forrásfájl.print("0");
}
} else forrásfájl.print("null");                    //üres típus
forrásfájl.println(";");               //return sorának lezárása
}
forrásfájl.println("\t}");                            //metódus vége
}
}

/** Az apt menetek számlálója. */
static private int menetszámláló;

/**
APT menet végét jelző eseménykezelő metódus.

@param esemény Az APT menet végét jelző eseményobjektum.
*/
public void roundComplete(com.sun.mirror.apt.RoundCompleteEvent esemény) {
menetszámláló++;
esemény.getSource().getMessager().printNotice(
"-- APT "+menetszámláló+". menet vége --\n"); //menetállapot jelzése
esemény.getSource().getMessager().printNotice("Forrásfájlgenerálás: "+
(esemény.getRoundState().sourceFilesCreated()?"":"nem ")+"történt\n");
esemény.getSource().getMessager().printNotice("Bájtkódgenerálás: "+
(esemény.getRoundState().classFilesCreated()?"":"nem ")+"történt\n");
esemény.getSource().getMessager().printNotice("Hiba: "+
(esemény.getRoundState().errorRaised() ? "" : "nem ")+"történt\n");
if (esemény.getRoundState().finalRound())
esemény.getSource().getMessager().printNotice("** Generálás vége **");
}
}

/**
Tesztinterfész az üres implementáció generáláshoz.
Üres (jelző) interfész, nem kell hozzá megvalósító osztályt létrehozni.

@see elte.java2_utikalauz5.programok.APTTeszt
@since Java 2 Útikalauz programozóknak 5.0
*/
@ImplGeneralas(Mod.NEM_KELL)
interface APTTeszt1 {
}

/**
Tesztinterfész az üres implementáció generáláshoz. Alapértelmezett visszatérési
értékekkel kell hozzá megvalósító osztályt létrehozni.

@see elte.java2_utikalauz5.programok.APTTeszt
@since Java 2 Útikalauz programozóknak 5.0
*/
@ImplGeneralas(Mod.KELL_DEFAULT)
interface APTTeszt2 extends APTTeszt1 {

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
Üres szignatúrával.
*/
@ImplGeneralas.Return("HIBApróba")
void teszt0();

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
Az alapértelmezett generált visszatérési érték {@code false} lesz.
*/
public boolean teszt1();

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
Az alapértelmezett generált visszatérési érték {@code 0} lesz.
*/
@ImplGeneralas.Return("Integer.MAX_VALUE")
public int teszt2();

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
Az alapértelmezett generált visszatérési érték {@code '\u005cu0000'} lesz.
*/
public char teszt3(int i[], float f, double d, long l);

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
Az alapértelmezett generált visszatérési érték {@code null} lesz.
*/
public Object teszt4(String s);
}

/**
Tesztinterfész az üres implementáció generáláshoz.
A csomagszintű beállítás miatt kell hozzá megvalósító osztályt létrehozni.

@see elte.java2_utikalauz5.programok.APTTeszt
@since Java 2 Útikalauz programozóknak 5.0
*/
interface APTTeszt3 extends APTTeszt2 {

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
A generált visszatérési érték megadása explicit történik.
*/
@ImplGeneralas.Return("v.toArray(new String[v.size()])")
public String[] teszt11(java.util.Vector<String> v);

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
A generált visszatérési érték megadása explicit történik.
*/
@ImplGeneralas.Return("c.iterator()")
public <E> java.util.Iterator<E> teszt12(java.util.Collection<E> c);
}

/**
Tesztinterfész az üres implementáció generáláshoz.
Kell hozzá megvalósító osztályt létrehozni.

@see elte.java2_utikalauz5.programok.APTTeszt
@since Java 2 Útikalauz programozóknak 5.0
*/
@ImplGeneralas(Mod.KELL_EXTENDS)
interface APTTeszt4 extends APTTeszt3 {

/**
Tesztmetódus az üres interfészimplementáció generáláshoz.
A generált visszatérési érték megadása explicit történik.
*/
@ImplGeneralas.Return("g.value()")
public Mod teszt21(ImplGeneralas g, String... args) throws Error;
}