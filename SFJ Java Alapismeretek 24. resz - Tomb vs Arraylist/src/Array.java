import java.util.ArrayList;

public class Array {

	public static void main(String[] args) {
		
String[] simplearray = new String[2];

simplearray[0] = "alma";
simplearray[1] = "korte";

ArrayList<String> list = new ArrayList<String>();
list.add("alma");
list.add("korte");
list.get(0);
int b = list.size();

System.out.println(list.get(0));

list.remove(0);



	}

}
