package teszt;

public class Main {

	  public static void main(String[] args) {
		    LinkedList<Byte> xs = new LinkedList<Byte>();    // byte lista
		    xs.add(new Byte("0")); xs.add(new Byte("1"));
		    Byte x = xs.iterator().next();
		    LinkedList<String> ys = new LinkedList<String>();    // String lista
		    ys.add("zero"); ys.add("one");
		    String y = ys.iterator().next();
		    LinkedList<LinkedList<String>> zs = new LinkedList<LinkedList<String>>();
		    zs.add(ys);     // String listák listája
		    String z = zs.iterator().next().iterator().next();
		 
		    System.out.println(xs);
	  }

		}


