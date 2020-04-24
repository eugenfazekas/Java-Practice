package v36.bridge;

import java.util.Random;

public class BridgeMain {

	public static void main(String[] args) {
		
	IntegerNode intNode = new IntegerNode(5);
	intNode.setData(8);
	
	Node rawNode = intNode;
	//rawNode.setData("Hello");
	 
	Integer num = intNode.getData();
	System.out.println(num);
	
	Random veletlenSzamGenerator = new Random();
	
	int egy = veletlenSzamGenerator.nextInt(3)+1;
	
	System.out.println(egy);

	}
	
}
