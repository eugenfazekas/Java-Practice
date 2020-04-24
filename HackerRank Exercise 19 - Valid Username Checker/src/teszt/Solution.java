package teszt;

import java.util.Scanner;

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "\\b(?=\\w{8,30}\\b)[A-Za-z]{1}[A-Za-z0-9_]{1,30}$";
}


public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}
//   \\b(?=\\w{8,30}\\b)[A-Za-z]{0,1}[A-Za-z_]{1,30}[0-9]{0,20}