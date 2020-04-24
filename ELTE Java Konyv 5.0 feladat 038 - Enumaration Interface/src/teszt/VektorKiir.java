package teszt;

public class VektorKiir {

	static java.util.Vector v = new java.util.Vector(10);
	
	public static void main(String[] args) {
	
		for(int i = 0; i < 5; i++) v.insertElementAt(new Integer(i), i);
			v.insertElementAt("Szia Vilag!", 5);
			v.removeElementAt(2);
		for(java.util.Enumeration e = v.elements(); e.hasMoreElements();)
			System.out.print(e.nextElement() + " , ");
		
	}

}
