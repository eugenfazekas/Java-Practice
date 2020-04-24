package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class test {

  
	
	 
	  public static void main(String[] args){
	    Scanner scan = new Scanner(System.in);
	    
	    int one = scan.nextInt();
	    int two = scan.nextInt();
	    int three = scan.nextInt();
	    int four = scan.nextInt();
	    int five = scan.nextInt();
	    
	  
	    Prime out = new Prime();
	    out.checkPrime(one);
	    out.checkPrime(one,two);
	    out.checkPrime(one,two,three);
	    out.checkPrime(one,two,three,four);
	    out.checkPrime(one,two,three,four,five);
	    scan.close();
	  }
	  
	}

class Prime{
	
	LinkedList<Integer> tomb1 = new LinkedList<Integer>();
	LinkedList<Integer> tomb2 = new LinkedList<Integer>();
	LinkedList<Integer> tomb3 = new LinkedList<Integer>();
	LinkedList<Integer> tomb4 = new LinkedList<Integer>();
	LinkedList<Integer> tomb5 = new LinkedList<Integer>();
	
	PrimSzamok prime = new PrimSzamok();
   
	
	  
	   void checkPrime(int... i) {
		
		 for(int y=0 ; y<i.length; y++) {
			 
		
			 	 tomb1.add(i[0]);
			 	 
			 	 if(y!=0)
				 tomb2.add(i[0]);tomb2.add(i[1]);
				 
				 if(y!=0)
				 tomb3.add(i[0]);tomb3.add(i[1]);tomb3.add(i[2]);
				 
				 if(y!=0)
				 tomb4.add(i[0]);tomb4.add(i[1]);tomb4.add(i[2]);tomb4.add(i[3]);
				 
				 if(y!=0)
				 tomb5.add(i[0]);tomb5.add(i[1]);tomb5.add(i[2]);tomb5.add(i[3]);tomb5.add(i[4]);
		 }	
		
		 
		 
		for(int k = 0 ; k < tomb1.size();k++) {
			System.out.println("Tomb1 " +tomb1.get(k));
			prime.prim(tomb1.get(k));
		}
			 
		
		for(int k = 0 ; k < tomb2.size();k++) {
			System.out.println("Tomb2 " +"\t"+tomb2.get(k));
			prime.prim(tomb2.get(k));
		}
			 
		
		for(int k = 0 ; k < tomb3.size();k++) {
			System.out.println("Tomb3 " +"\t"+tomb3.get(k));
			 prime.prim(tomb3.get(k));
		}
			
		
		for(int k = 0 ; k < tomb4.size();k++) {
			System.out.println("Tomb4 " +tomb4.get(k));
			prime.prim(tomb4.get(k));
		}
			 
		
		for(int k = 0 ; k < tomb5.size();k++) {
			System.out.println("Tomb5 " +tomb5.get(k));
			prime.prim(tomb5.get(k));
		}
			 
				
	   }		
	}		
			
class PrimSzamok {
	
	void prim (int x) {
		
		if(x<2) return;
		
		else if(x == 2 || x == 3) 
			System.out.print("Primszam:"+x+" ");
			
			
		for(int n = 2 ; n < x-1 ; n++) {
				if(x % n == 0) 
		return;
		}	
		
		for(int n =2; n < x-1 ; n++) {
				if(x % n !=0) {
					System.out.print("Primszam: "+x+" ");
					return;
				}
		}
	}
}
 
