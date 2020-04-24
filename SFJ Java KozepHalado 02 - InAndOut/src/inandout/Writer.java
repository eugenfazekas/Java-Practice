package inandout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Writer {

	public void writeSingleChar() {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\skybo\\eclipse-workspace\\InAndOut\\src\\inout\\test.txt");
			fos.write(65);
			fos.flush();
			fos.close();
			System.out.println("Keszen vagyok!");
		}
		catch (Exception e) {
		
			System.out.println(""+ e);;
		}
	}

	public void writeMultipleCharacters() {
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\skybo\\eclipse-workspace\\InAndOut\\src\\inout\\test2.txt");
			String text = "San Franciscobol jottem";
			byte [] a = text.getBytes();
			fout.write(a);
			fout.flush();
			fout.close();
			System.out.println("Keszen vagyok!");
		}
		catch (Exception e) {
		
			System.out.println(""+ e);;
		}
	}
}
