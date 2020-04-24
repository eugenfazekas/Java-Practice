import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
	
		HashMap<String,Integer> tomb = new HashMap<String,Integer>();
 		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hany embert szeretnel benni a telefonkonyvbe?");
		int recordSzamok = scan.nextInt(); int i =0;
		
		while(recordSzamok-->0) {
			System.out.println("Kerem a Nevet");
			scan.nextLine();
			String entryName = scan.nextLine();
			System.out.println("Kerem a TelefonSzamot");
			int phoneNumber = scan.nextInt();		
	
			tomb.put(entryName, phoneNumber);
		}
	
		while (scan.hasNext()) {
			if(i == 0)
			scan.nextLine();
			String s = scan.nextLine();
			Integer value = tomb.get(s);
			if(value != null)
				System.out.println(s+"="+value);
			else
				System.out.println("Not Found");
			i++;
			}
		}
	}
	


