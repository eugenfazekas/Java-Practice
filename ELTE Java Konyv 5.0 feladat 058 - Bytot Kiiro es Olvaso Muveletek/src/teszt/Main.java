package teszt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int a = System.in.read();
		System.out.write(a);System.out.println(" "+a);
	
		byte b[] = {'S','z','i','a','!'};
		FileOutputStream out = new FileOutputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 058 - Kiiro es Olvaso Muveletek\\test1.txt");
		out.write(b);         // kiir egy tombot
		out.write(b[0]);      // Kiir egy tomb poziciot
		out.write(b, 0, 2);   // kiir egy tomb szakaszt
		out.flush();
		out.close();
		
		FileOutputStream out2 = new FileOutputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 058 - Kiiro es Olvaso Muveletek\\test4.txt");
		FileInputStream  fis2 = new FileInputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 058 - Kiiro es Olvaso Muveletek\\test3.txt");
		
		byte [] c = new byte[5];
		FileInputStream fis = new FileInputStream("C:\\Users\\skybo\\eclipse-workspace\\Konyv teszt 058 - Kiiro es Olvaso Muveletek\\test2.txt");
		fis.read(c, 0, 3);
		fis.close();
		for(byte i:c)
		System.out.print((char)i);
		
		
		masol0(fis2,out2);
		masol(fis2,out2);
		
	}
	public static void masol0 (FileInputStream in , FileOutputStream out) throws IOException {
		int b ;
		try {
			while ((b=in.read())!=-1) out.write(b);
		}finally {
			out.flush();
		}
	}
	
    final static int BLOKK_MERET = 1024;
    static void masol(FileInputStream in , FileOutputStream out) throws IOException {
    	byte[] b = new byte[BLOKK_MERET];
    	int hossz;
    	try {
			while ((hossz=in.read(b)) == BLOKK_MERET) out.write(b);
			if(hossz!= -1)out.write(b,0,hossz);
			 }finally { out.flush();}
	
           }
}