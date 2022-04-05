package teszt2;

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
    	
    for (int i = 100 ; i>=0 ; i--) {
        	
        	System.out.println(i);
        }
    
        try (Scanner scanner = new Scanner(System.in);)
        {
            System.out.println(scanner.nextBigInteger().isProbablePrime(100) ? "prime" : "not prime");
        }
        
    
    }
}