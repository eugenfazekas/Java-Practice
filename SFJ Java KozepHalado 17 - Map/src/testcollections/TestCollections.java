package testcollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestCollections {

	public static void main(String[] args) {

		Map<String,Integer> testmap = new HashMap<>();
		
		testmap.put("Gyula", 21);
		testmap.put("Gizi", 22);
		testmap.put("Jani", 23);
		
		//System.out.println(testmap);
		
		//testmap.remove("Gyula");
		 
	//	System.out.println(testmap.get("Jani"));
		
		//System.out.println(testmap);
		
		Iterator it = testmap.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			
			String key = (String)pair.getKey();
			Integer value = (Integer)pair.getValue() ;		
			
			System.out.println(key + " = " + value);
			if(value.equals(21))
				it.remove();
			
		}
		System.out.println("Vegleges" +testmap);
	}

}
