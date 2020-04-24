package teszt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
	
	
	static Calendar c = Calendar.getInstance();

    public static String findDay(int month, int day, int year) {

   c.set(year, month-1, day);
   String actualDay = String.valueOf(c.getTime());
   
   System.out.println(c.getTime());
 
   System.out.println(Calendar.DAY_OF_WEEK);
   String finalDay = null;
   
   if (String.valueOf(actualDay).contains("Mon"))
	   finalDay = "MONDAY";
   
   if (String.valueOf(actualDay).contains("Tue"))
	   finalDay = "TUESDAY";
   
   if (String.valueOf(actualDay).contains("Wed"))
	   finalDay = "WEDNESDAY";
   
   if (String.valueOf(actualDay).contains("Thu"))
	   finalDay = "THURSDAY";
   
   if (String.valueOf(actualDay).contains("Fri"))
	   finalDay = "FRIDAY";
   
   if (String.valueOf(actualDay).contains("Sat"))
	   finalDay = "SATURDAY";
   
   if (String.valueOf(actualDay).contains("Sun"))
	   finalDay = "SUNDAY";
 
  System.out.println(finalDay);
   
   return finalDay;
    	
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("C:\\Users\\skybo\\Desktop\\HackerRank Ecxercises\\Java Excersize 10\\bR.txt")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);
//
//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}