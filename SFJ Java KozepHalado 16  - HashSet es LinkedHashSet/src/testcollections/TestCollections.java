package testcollections;

import java.util.Arrays;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TestCollections {

	public static void main(String[] args) {

		String[] array = {"Gizi","Gyula","Krisz","Norbi","Gyula"};
		
		List<String> list1 = Arrays.asList(array);
		
		System.out.println("list1:" + list1);
		
	
		Set<String> set = new LinkedHashSet<>(list1);
		
		System.out.println("set1:" + set);
		

//		Set<String> set = new HashSet<>(list1);
//		
//		System.out.println("set1:" + set);
		
	}

}
