package teszt;

/**
Szálcsoport egyben kezelése.

@link.forrásfájl {@docRoot}/../data/thread/src SzalCsoport2.java
@link.letöltés {@docRoot}/../data/thread SzalCsoport2.jar
@since Java 2 Útikalauz programozóknak
*/
class SzalCsoport2 {
  public static void main(String[] args) {
    ThreadGroup group = new ThreadGroup("Normal prioritású csop.");
    Thread thread = new Thread(group, "Max priotitású szál");

    thread.setPriority(Thread.MAX_PRIORITY);       // Max prioritásra a szálat
    group.setMaxPriority(Thread.NORM_PRIORITY);    // Normálra(5) a csop. MAXját
    System.out.println("Csop MAX: " + group.getMaxPriority());
    System.out.println("Szál MAX: " + thread.getPriority());
  }
}