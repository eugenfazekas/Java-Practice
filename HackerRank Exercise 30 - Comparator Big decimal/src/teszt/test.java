package teszt;

import java.math.BigDecimal;
import java.security.acl.LastOwnerException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		String pattern = "###.000";
		DecimalFormat df = new DecimalFormat(pattern);

		String[] st = {"000.000",".12","0.12","10.21","4.0001"};
		Double[] szam = new Double[st.length];
		
		for(int i = 0 ; i < st.length; i++) {
		 szam[i] = Double.parseDouble(st[i]);
		 System.out.println(st[i]);
			}
		Arrays.sort(szam);
		
		for(int i = 0; i< szam.length; i++)
			System.out.println(szam[i].doubleValue());
		}
	}


