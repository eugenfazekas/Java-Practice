import java.util.ArrayList;
import java.util.List;

public class DinamikusTombok {

	public static void main(String[] args) {
		String[] nevek1 = new String[] {"Bozsi", "Alma" ,"Evi", "Timi" };
		List<String> nevek2 = new ArrayList<String>();
		List<Integer> szamok = new ArrayList<Integer>();
		
		for(int i = 0 ; i < nevek1.length; i++) {
			nevek2.add(nevek1[i]);
			}
			
			for(int i = 0 ; i < nevek2.size(); i++) {
				System.out.print(nevek2.get(i)+ " ");
			}
				System.out.println("");
				
				nevek2.add("Kati");
				
				for(int i = 0 ; i < nevek2.size(); i++) {
				System.out.print(nevek2.get(i)+ " ");
				}
			}
		}


