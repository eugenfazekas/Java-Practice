package inandout;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

	


	public void bufferWriter() throws FileNotFoundException , IOException  {
		
	FileOutputStream fout = new FileOutputStream("C:\\Users\\skybo\\eclipse-workspace\\InAndOut\\src\\inout\\test3.txt");
	BufferedOutputStream bout = new BufferedOutputStream(fout);
	
	String text = "San Franciscobol jottem";
	byte a[] = text.getBytes();
	bout.write(a);
	bout.flush();
	bout.close();
	fout.close();
	//System.out.println("Keszen vagyok!");
	}
}
