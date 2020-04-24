package teszt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws IOException {
	
		Writer w = new OutputStreamWriter(new FileOutputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 060 - Beolvaso Peldak\\test1.txt"),"ISO8859_2");
		w.write(40);
		w.write("Ozike");
		w.flush();
		
		char [] b = new char[10];
		Reader fr = new InputStreamReader(new FileInputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 060 - Beolvaso Peldak\\test1.txt"),"ISO8859_2");
	    fr.read(b, 0,9);
		for(char z:b )
		System.out.print(z);
		
		FileOutputStream fout = new FileOutputStream("Vacsora.van");
		DataOutputStream dout = new DataOutputStream(fout);
		dout.writeDouble(14.0);
	
		DataInputStream din = new DataInputStream(new FileInputStream("Vacsora.van"));
		double e = din.readDouble();
		System.out.println(e);
	} 

}
