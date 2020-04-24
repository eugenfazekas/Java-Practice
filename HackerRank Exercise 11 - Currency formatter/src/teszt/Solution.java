package teszt;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double payment = scanner.nextDouble();
        scanner.close();

            
        DecimalFormat us = new DecimalFormat("$###,###.##"); 
        
        
        DecimalFormat india = new DecimalFormat("Rs'.'###,###.##"); 
        
        DecimalFormat china = new DecimalFormat("￥###,###.##"); 
        
        
     DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        formatSymbols.setDecimalSeparator(',');
        formatSymbols.setGroupingSeparator(' ');

        DecimalFormat france = new DecimalFormat("###,###.## €", formatSymbols);
        
        String usa = String.valueOf(us.format(payment));
        String indi = String.valueOf(india.format(payment));
        String kina = String.valueOf(china.format(payment));
        String francia = String.valueOf(france.format(payment));
        
                
        System.out.println("US: " +usa );
        System.out.println("India: "+indi);
        System.out.println("China: "+kina);
        System.out.println("France: "+francia);
    }
}


