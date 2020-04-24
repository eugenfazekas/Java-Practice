package teszt;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
	
		
		//Bufferolas
		FileInputStream fis = new FileInputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 059 - Adatfolyamok Buffereles 1\\test2.txt");
		BufferedInputStream bin = new BufferedInputStream(fis);
		DataInputStream din = new DataInputStream(bin);
//		double osszeg = 0.0;
//		for(int i = 0 ; i < 10000; ++i) osszeg += din.readFloat();
		int i = 0;
		String result = "";
		while((i=din.read()) != -1) {
			result += (char)i;
		}
		System.out.println(result);
		din.close();
		
		BufferedInputStream in1 = new BufferedInputStream(System.in);
		System.out.write(System.in.read());
		System.out.write(in1.read());
	}

}
