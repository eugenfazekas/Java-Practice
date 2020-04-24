package teszt;

public class Main {

	 public static void main(String args[]) {
		    ClonePelda cp1 = new ClonePelda(true);
		    cp1.tombelem(1, 3);
		    System.out.println("cp1 == "+cp1);
		    ClonePelda cp2 = new ClonePelda(false);
		    cp2.tombelem(1, 4);
		    System.out.println("cp2 == "+cp2);
		    try {
		      ClonePelda cp3 = (ClonePelda)cp1.clone();
		      System.out.println("Siker�lt cp1 kl�noz�sa");
		      System.out.println("cp3 == "+cp3);
		    } catch (CloneNotSupportedException e) {
		      System.out.println("Nem siker�lt cp1 kl�noz�sa");
		    }
		    try {
		      ClonePelda cp4 = (ClonePelda)cp2.clone();
		      System.out.println("Siker�lt a cp2 kl�noz�sa");
		      System.out.println("cp4 == "+cp4);
		    } catch (CloneNotSupportedException e) {
		      System.out.println("Nem siker�lt cp2 kl�noz�sa");
		    }
		  }

}
