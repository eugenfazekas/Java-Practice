import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 5; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 5; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
  
        int outPut1 = 0;
        int outPut2 = 0;
        
        for(int m = 0 ; m < arr.length; m++) {
        	outPut1 += arr[m][m]; 
        	for (int n =0 ; n< arr[m].length; n++) {
        		if( arr[m][n]>1|| arr[n][m]>1) {
        			outPut2 += arr[n][n] ;
        		}
        	}
        }System.out.println(outPut1+ outPut2);
    }
}