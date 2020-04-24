package teszt;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		double myNumber = 4242.4242;
		DecimalFormat df = new DecimalFormat("#,##0.0000");
		System.out.println(df.format(myNumber));
		df = new DecimalFormat("Szazalekos formaban: ##.#%");
		System.out.println(df.format(myNumber));
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(myNumber));
		df = new DecimalFormat("#,##0.00 \u00A4");
		df.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale ("hu","HU")));
		String myNumberString = df.format(myNumber);
		System.out.println(myNumberString);
		try {
			System.out.println("Ertelmezve: " + df.parse(myNumberString));
		}catch(ParseException e) {}
		
		
	}

}
