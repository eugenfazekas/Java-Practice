import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    
        HashMap<String,Integer> tomb = new HashMap<String,Integer>();
         
        Scanner scan = new Scanner(System.in);
        
  
        int recordSzamok = scan.nextInt();
        while(recordSzamok-->0) {
           
            String entryName = scan.nextLine();
           
            int phoneNumber = scan.nextInt();        
    
            tomb.put(entryName, phoneNumber);
        }
    
        while (scan.hasNext()) {
            String s = scan.nextLine();
            System.out.println(tomb.get(s));
        }
    }
    

}