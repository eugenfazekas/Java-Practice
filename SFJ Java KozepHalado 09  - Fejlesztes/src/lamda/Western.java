package lamda;

public class Western {

	

	
	public String letsDoSomething (String input1, String input2, Integer input3, boolean input4) {
		
		//Kalkulacio
	System.out.println(input4);
		return input1 + input2 + input3;
	}

	public String letsDoSomething (String input1, String input2, Integer input3 ) {
		
	System.out.println("Uj");
		return letsDoSomething(input1, input2, input3,false );
	}

	
}
