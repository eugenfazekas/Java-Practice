package teszt;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int egy = Integer.MIN_VALUE; 
        int ketto = Integer.MIN_VALUE; 
        int  harom = Integer.MIN_VALUE;
        Deque <Integer> deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            Integer num = in.nextInt();
           deque.add(num);
         if(i == 0) {
        	 egy= num;
        	 System.out.println("Level 1");
         }
           
           if(i>0&& egy!= num && ketto == Integer.MIN_VALUE) {
        	   ketto = egy;
           	   egy = num;
           	 
           	   System.out.println("Level 2");
           }   
           if ( i>1 &&  egy !=num &&harom ==Integer.MIN_VALUE) {
        	   	harom=ketto;
           		ketto = egy;
           		egy = num;
           		num = Integer.MIN_VALUE;
           		System.out.println("Level 3");
           }
        }
               if(harom != Integer.MIN_VALUE )
            	   System.out.println(3);
               if(ketto != Integer.MIN_VALUE && harom ==Integer.MIN_VALUE)
            	   System.out.println(2);
               if(egy != Integer.MIN_VALUE && harom ==Integer.MIN_VALUE &&ketto ==Integer.MIN_VALUE)
            	   System.out.println(1);
    }
    
}