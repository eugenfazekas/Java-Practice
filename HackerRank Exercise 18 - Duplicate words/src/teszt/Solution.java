package teszt;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args){
     
    	Scanner scan = new Scanner(System.in);
    	
    	int sentences = scan.nextInt();
    	
    	while(sentences-- >0) {
    		
    	
    	String s = scan.nextLine();
    	
    	String[]str = s.split(" ");
    	
    	Set<String> mySet= new LinkedHashSet<String>();
    	
    	for(String x:str)
    		
    		mySet.add(x);
    	
    	Iterator itr = mySet.iterator();
    	
    	while(itr.hasNext())
    	System.out.print(itr.next() + " "); System.out.println();
    	}
    }
}
