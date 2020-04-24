package v36;

import java.util.ArrayList;
import java.util.List;

public class ElementsToArrayConverter<T> {

	public T[] convertToArray(T first, T second) {
		T[]array = (T[]) new Object[2];
		array[0] = first;
		array[1] = second;
		return array;
			}
	
	public List<T> convertToList(T first, T second){
		List<T> list = new ArrayList<>();
		list.add(first);
		list.add(second);
		return list;
	}
	
	
}
