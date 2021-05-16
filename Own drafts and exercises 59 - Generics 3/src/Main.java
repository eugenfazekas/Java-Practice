import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Container<Integer, String> container = new Container<>(12, "Hello");
		int val1 = container.getItem1();
		String val2 = container.getItem2();	
		System.out.println(val1 + " " + val2);
		
		
		Set<String> mySet1 = new HashSet<String>();
		mySet1.add("First");
		mySet1.add("Second");
		mySet1.add("Third");
		
		Set<String> mySet2 = new HashSet<String>();
		mySet1.add("First");
		mySet1.add("Second");
		mySet1.add("Computer");
		
		Set<String> resultSet = union(mySet1,mySet2);
		
		Iterator<String> itr = resultSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	public static <E> Set<E> union (Set<E> set1, Set<E> set2) {  // E = Object type what we use ; ......  Set<E> = return type of function 
		Set<E> result = new HashSet<E>(set1);
		result.addAll(set2);
		return result;
	}
}
