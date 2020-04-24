package teszt;

import java.lang.annotation.*;                       //metaannotációk miatt kell

/**
Interfészek üres implementációjának előállítását vezérlő annotáció.
Csomagszinten megadva hatása a csomag összes interfészére érvényes.
Az interfész szintjén megadva felülbírálja a csomagszintű beállítást.

@see elte.java2_utikalauz5.programok.ImplGeneralas.Return
@see elte.java2_utikalauz5.programok.APTTeszt
@link.forrásfájl {@docRoot}/../data/programok/src ImplGeneralas.java
@since Java 2 Útikalauz programozóknak 5.0
*/
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.PACKAGE, ElementType.TYPE})
public @interface ImplGeneralas {

    /**
    Interfészek üres implementációjának előállítását vezérlő beágyazott
    felsorolási típus. Értékeit a beágyazó annotációhoz kell megadni.<P>
    Mivel a {@code values} és {@code valueOf} metódusokat a fordító generálja,
    ezért azokhoz nem adható lokalizált dokumentációs leírás.
    */
    public enum Mod {

        /**
        Az interfészek kiterjesztési hierarchiáját követő öröklési hierarchiába
        rendezett üres implementációját előíró érték.
        */
        KELL_EXTENDS,

        /**
        Interfészek üres, a Return annotáció figyelembe vételével történő
        implementációját előíró érték.
        */
        KELL_RETURN,

        /**
        Interfészek alapértelmezett visszatérési értéket visszaadó üres
        implementációját előíró érték.
        */
        KELL_DEFAULT,

        /**
        Interfészek üres implementációjának elhagyását előíró érték.
        Akkor használhatjuk, ha a csomagszinten bekapcsolt generálást egyes
        interfészeknél ki szeretnénk kapcsolni.
        */
        NEM_KELL
    }

    /**
    Interfészek üres implementációjának előállítását vezérlő érték.
    */
    Mod value() default Mod.KELL_RETURN;

    /**
    Üres interfészimplementációs metódus visszatérési értékét előíró beágyazott
    annotáció. Értéket visszaadó interfészmetódusok előtt szövegesen megadható
    vele, hogy a generált üres implementáció mit adjon vissza.
    Elhagyása és letíltása esetén {@code 0}, {@code false},
    {@code '\u005cu0000'}, vagy {@code null} kerül visszaadásra a visszatérési
    típusnak megfelelően.

    @see elte.java2_utikalauz5.programok.ImplGeneralas
    */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.METHOD)
    public @interface Return {

        /**
        Üres interfészimplementációs metódus visszatérési értékét előíró szöveg.
        */
        String value();
    }
}