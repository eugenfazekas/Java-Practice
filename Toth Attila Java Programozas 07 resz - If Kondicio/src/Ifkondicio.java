
public class Ifkondicio {

	public static void main(String[] args) {
		
		int eletkor = 20 ;
		
		boolean sor = false;

		if(eletkor <= 0) 
			System.out.println("Meg meg sem szulettel");
		else if(eletkor > 0 && eletkor <5)
			System.out.println("Meg kisbaba vagy");
		
		else if(eletkor >= 5 && eletkor < 8)
			System.out.println("Tuddsz mar egyedul pisilni");
		
		else if(eletkor >= 8 && eletkor < 15)
			System.out.println("mar suliba jarsz");
		
		else if(eletkor >=15 && eletkor < 18)
			System.out.println("mar csajozol , de meg nem pialhatsz");
						
		else {
			System.out.println("nagykoru vagy, ihatsz sort meg palinakt");
		
		if(sor) 
			System.out.println("csapos hozza sort");
		
		else
			System.out.println("Inkabb palinkat hozz");
	}

		if(!(-2>0 && -4>0 && -5>4))
			System.out.println("Igyunk Whiskyt");
}
	
	
}
