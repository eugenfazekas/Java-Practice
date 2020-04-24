package teszt;

import java.math.BigDecimal;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

 Arrays.sort(s, 0, n, Collections.reverseOrder(new Comparator<String>() {
      @Override
  public int compare(String lhs, String rhs)
   {
         BigDecimal a = new BigDecimal(lhs);
         BigDecimal b = new BigDecimal(rhs);
          return a.compareTo(b); 
          }
      }));

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}