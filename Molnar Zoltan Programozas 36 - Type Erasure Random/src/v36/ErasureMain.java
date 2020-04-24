package v36;

import java.util.Arrays;
import java.util.List;

public class ErasureMain {

	public static void main(String[] args) {
		
	ElementsToArrayConverter<String> converter = new ElementsToArrayConverter<>();

		Object[] elementArray = converter.convertToArray("dog", "cat");
		List <String> elementList = converter.convertToList("bird", "goat");
		
		System.out.println(Arrays.toString(elementArray));
		System.out.println(elementList);
		
	}

	public static <T> int count (T[] array, T element) {
		int count = 0 ;
		for(int i = 0; i < array.length; i++) {
			if(element.equals(array[i])) {
				count++;
			}
		}
		return count;
	}
	
}
