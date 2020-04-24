package teszt;

/**
Sz�lcsoport egyben kezel�se.

@link.forr�sf�jl {@docRoot}/../data/thread/src SzalCsoport2.java
@link.let�lt�s {@docRoot}/../data/thread SzalCsoport2.jar
@since Java 2 �tikalauz programoz�knak
*/
class SzalCsoport2 {
  public static void main(String[] args) {
    ThreadGroup group = new ThreadGroup("Normal priorit�s� csop.");
    Thread thread = new Thread(group, "Max priotit�s� sz�l");

    thread.setPriority(Thread.MAX_PRIORITY);       // Max priorit�sra a sz�lat
    group.setMaxPriority(Thread.NORM_PRIORITY);    // Norm�lra(5) a csop. MAXj�t
    System.out.println("Csop MAX: " + group.getMaxPriority());
    System.out.println("Sz�l MAX: " + thread.getPriority());
  }
}