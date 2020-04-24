package teszt;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	
static {
		
		FileOutputStream out = null;
		int data =  40;
		try {
			out = new FileOutputStream("kimenet.txt");
			out.write(data);
			out.flush();
		}catch(IOException e){
			System.out.println("Fajl irasi hiba!");
		}finally {
			if(out != null) {
				try {
					out.close();
				}catch(IOException ioe) {
					System.out.println("Lezarasi Hiba!");
				}
			}
		}
	}

	public static void main(String[] args) {
	
		for(int i = 0; i< args.length; i++) 
			try {
				System.out.println("Argumentumok: " + args[i] + i);
				
				
				
				System.out.println("Teszt \""+args[i]+"\" nem valtot ki kivetelt");
			}catch(Exception e ) {
				System.out.println("Teszt \""+args[i]+"\"kivaltott egy kivetelt" + e.getClass() + "\n" + e.getMessage() + "uzenettel");
			}
	}

}
