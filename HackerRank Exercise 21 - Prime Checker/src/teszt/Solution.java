package teszt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.in;

public class Solution {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
class Prime{

	PrimSzamok prime = new PrimSzamok();
	
	int[]tomb1 = new int[5];
	
		void checkPrime(int... z) {
		
		 for(int a = 0; a< z.length; a++) {
		
			 if(z.length == 5 && z[0] !=0 &&z[1] !=0 && z[2] !=0 && z[3] !=0 &&z[4] !=0 )
				 tomb1[a] = z[a];
		 }
	
		 for(int i = 0 ; i< tomb1.length; i++)
			 if(z.length == 5)
				 while(i<1) {
					 prime.prim(tomb1[0]);
					 System.out.println();
					 prime.prim(tomb1[0]);prime.prim(tomb1[1]);
					 System.out.println();
					 prime.prim(tomb1[0]);prime.prim(tomb1[1]);prime.prim(tomb1[2]);
					 System.out.println();
					 prime.prim(tomb1[0]);prime.prim(tomb1[1]);prime.prim(tomb1[2]);prime.prim(tomb1[3]);prime.prim(tomb1[4]);
					 i++;
				 }
		}
}
class PrimSzamok {
	
	void prim (int x) {
		
		if(x<2) return;
		
		else if(x == 2 || x == 3) 
			System.out.print(x+ " ");
						
		for(int n = 2 ; n < x-1 ; n++) {
				if(x % n == 0) 
		return;
		}	
		
		for(int n =2; n < x-1 ; n++) {
				if(x % n !=0) {
					System.out.print(x+ " ");
					return;
				}
		}
	}
}

	
