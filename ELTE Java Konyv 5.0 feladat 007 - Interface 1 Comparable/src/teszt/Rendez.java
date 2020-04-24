package teszt;

public class Rendez {

	public static <T extends Comparable<T>> void rendez(T[] elemek) {
		for (int i = 0; i<elemek.length ;++i)
			for(int j=i+1; j<elemek.length; ++j)
				if(elemek[i].compareTo(elemek[j]) < 0) {
					T temp = elemek[i];
					elemek[i] = elemek[j];
					elemek[j] = temp;
				}
	} 
	
}
