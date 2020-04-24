package teszt;

public class Teszt {

	public static void dobo(String s) throws MyException{
		int i  = 0;
		try{
			if(s.equals("osztas")) i = i/i;
			if(s.equals("null")) {
				s=null;
				i=s.length();
			}
			if(s.equals("teszt")) throw new MyException("Teszt uzenet");
		}finally {
			System.out.println("[dobo(\"" + s +"\") vege]");
		}
	}
	
	
}
