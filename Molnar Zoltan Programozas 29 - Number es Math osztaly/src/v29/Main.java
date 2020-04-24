package v29;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
	
		byte a = 8;
		
		Byte A = new Byte(a);  Byte B = Byte.valueOf(A);
		
		System.out.println(A == B); //false
		
		System.out.println(A.equals(B));	// true
		
		System.out.println(Math.abs(-5.569));	// 5.569
		
		System.out.println(Math.ceil(-5.569));	//-5.0
		
		System.out.println(Math.floor(-5.569));	//-6.0	
		
		System.out.println(Math.rint(-5.569));	//-6.0
		
		System.out.println(Math.rint(-5.469));	//-5.0
		
		System.out.println(Math.round(-5.569));	//-6
		
		System.out.println(Math.max(8, 6));	//8
		
		System.out.println(Math.pow(5, 2));	//25
		
		System.out.println(Math.sqrt(25));	//5
		
		int[] tomb = {8,2,5,1,3,4};
		
		Arrays.parallelSort(tomb);
		
		for(int i = 0 ; i< tomb.length; i++)
			
			System.out.println(tomb[i]);
		
		
	}

}
