package teszt;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberInputStream;
import java.io.LineNumberReader;
import java.io.PushbackReader;
import java.io.Reader;
 class Main {

	public static void main(String[] args) throws IOException {
	
		LineNumberReader lin = new LineNumberReader(new FileReader("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 061 - FileInputStream Sorolvasas\\Vacsora.txt"));
		int data = lin.read();
		int l =0;
		char[] a = new char[1];
		String b = "" ;
		while((l=lin.read()) != -1){
			int lineNumber = lin.getLineNumber();
			if(lineNumber == 2 ) {
				for(int i = 0 ; i< a.length; i++) {
				a[i]=(char)l;
				
			b += a[i];
				}
			}
		}
		lin.close();
		System.out.print(b);
		
		String sor;
		LineNumberReader be = new LineNumberReader(new FileReader("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 061 - FileInputStream Sorolvasas\\Vacsora1.txt"));
		while(( sor = be.readLine()) != null) 
			if(sor.endsWith("or")) 
				System.out.println(be.getLineNumber());
		be.close();
		
		PushbackReader be2 = new PushbackReader(new InputStreamReader(System.in),2);
		int c = be2.read();
		while((c==' ')||(c=='\t')||(c=='\r')||(c=='\n'))
			c= be2.read();
		if(c!= -1)
			be2.unread(c);
			be2.unread(' ');
	}

}
