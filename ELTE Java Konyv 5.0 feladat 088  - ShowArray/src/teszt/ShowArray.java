package teszt;

import java.lang.reflect.*;

/**
Tömb.

@link.forrásfájl {@docRoot}/../data/reflect/src ShowArray.java
@link.letöltés {@docRoot}/../data/reflect ShowArray.jar
@since Java 2 Útikalauz programozóknak 5.0
*/
public class ShowArray {
    public static void main(String args[]) {
        if(args.getClass().isArray()) {
            System.out.println("Típus: " + args.getClass().getName());
            System.out.println("Elem típusa: " +
                args.getClass().getComponentType().getName());
            if(Array.getLength(args) > 0) {
                System.out.println("Első elem: " + Array.get(args, 0));
            }
        }
    }
}