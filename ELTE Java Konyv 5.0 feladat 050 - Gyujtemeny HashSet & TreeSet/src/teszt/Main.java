package teszt;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Set<Object> egyedi = new HashSet<Object>();
		
		Set<Object> duplikalt = new TreeSet<Object>();
		
		for(int i = 0; i< args.length; i++)
			if(!egyedi.add(args[i])) duplikalt.add(args[i]);
		egyedi.removeAll(duplikalt);
		
		System.out.println("Egyedi szavak:   "+egyedi);
		System.out.println("Duplikalt szavak:"+duplikalt);
		
	}

}
