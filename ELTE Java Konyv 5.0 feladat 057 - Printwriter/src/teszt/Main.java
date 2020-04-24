package teszt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

	PrintWriter out = new PrintWriter(new FileWriter("hello.txt"));  
	out.println("Hello Vilag!");
	out.close();
	}

}
