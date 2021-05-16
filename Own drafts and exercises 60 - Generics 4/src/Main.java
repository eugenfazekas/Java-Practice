import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Object> output = new ArrayList< Object >();
		List<Long>    input = new ArrayList< Long >();

		Collections.copy(output,input);  

	}

	public static <T> void copy ( List<? super T> dest, List<? extends T> src) { 
	      for (int i=0; i<src.size(); i++)
	        dest.set(i,src.get(i));
	  }
}
