package teszt;

/**
Egy r�vid p�lda.

@link.forr�sf�jl {@docRoot}/../data/reflect/src Whoami.java
@link.let�lt�s {@docRoot}/../data/reflect Whoami.jar
@since Java 2 �tikalauz programoz�knak 5.0
*/
public class ShowArray {
    public static void tell(Object o) {
        System.out.println("Az �n nevem " + o.getClass().getName() +
            ", �s a(z) " + o.getClass().getSuperclass().getName() +
            " lesz�rmazottja vagyok.");
    }
    public static void main(String args[]) {
        tell(new ShowArray());
    }
}