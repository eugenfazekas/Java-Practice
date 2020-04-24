package teszt;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        Double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String us = format.format(payment);
        
        
        format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = format.format(payment);
      
        
        format = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = format.format(payment);
      
        
       
        
        
       
        DecimalFormat indi = new DecimalFormat("Rs'.'###,###,###.##"); 
        indi.setMinimumFractionDigits(2);
        String india = String.valueOf(indi.format(payment));
        
        
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

	}


