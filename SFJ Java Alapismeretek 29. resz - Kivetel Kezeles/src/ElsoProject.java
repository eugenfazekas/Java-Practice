import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ElsoProject {

	public static void main(String[] args) {

		File file = new File("D:/2.txt");
		try {
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException ex) {
			System.out.println("GAz van!" + ex);
		}

	}

}
