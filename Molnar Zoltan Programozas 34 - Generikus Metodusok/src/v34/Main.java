package v34;

public class Main {

	public static void main(String[] args) {
	
		Integer[] numbers = {1,2,3,4,5};
		Integer third =get(numbers,2);
		
		String[] labels = {"fun","trailer","movie","comedy"};
		boolean hasLabel = contains(labels,"majom");
		boolean whyWorks = contains(labels, new Integer(5));
		boolean whatsGoingOn = contains(labels,new Animal());

		System.out.println(hasLabel);
		System.out.println(whyWorks);
		System.out.println(whatsGoingOn);
		System.out.println(third);
	}

	public static <T> T get(T[] array,int i) {
		return array[i];
	}
	public static <T> boolean contains(T[] array,T item) {
		for(int i = 0; i< array.length; i++) {
			if(array[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
}
