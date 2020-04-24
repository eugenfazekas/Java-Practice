package array;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterator1 {

	public static void main(String[] args) {
	
LinkedList<String> list1 = new LinkedList<> ();

list1.add("Gyula");
list1.add("Krisz");

System.out.println(list1);

Iterator<String> it = list1.iterator();
 
 while(it.hasNext()) {
	 String actual = it.next();
	 if(actual.equals("Gyula"))
		 it.remove();
	 System.out.println(it.next());
 		}
	
	}
}
