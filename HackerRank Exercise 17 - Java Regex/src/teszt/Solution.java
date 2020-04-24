package teszt;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args){
    
    	Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}
 
class MyRegex{
	
	String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
	public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
		
		
	
}


