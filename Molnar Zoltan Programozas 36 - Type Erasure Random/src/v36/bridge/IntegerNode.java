package v36.bridge;

public class IntegerNode extends Node<Integer>{

	public IntegerNode(Integer number) {
		super(number);
		
	}

	public void setData(Integer number) {
		System.out.println("IntegerNode.setData invoked");
		super.setData(number);
	}
	
}
