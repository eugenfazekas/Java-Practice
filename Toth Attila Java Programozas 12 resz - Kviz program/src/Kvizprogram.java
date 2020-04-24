import java.util.Scanner;

public class Kvizprogram {

	public static void main(String[] args) {
		System.out.println("Valasz Egy Varost");
		 System.out.println("Becs,Budapest, Bukarest, Berlin");	 
		 
		 Scanner input = new Scanner(System.in);
		 boolean futas = true;
		 int talalat = 0;
		 int Pontszam = 0;
		 
		 while(futas) {
			  String text = input.nextLine();
			 switch(text) {
			 case "Becs":
				 System.out.println("Nem Talaltad el, nem Becs!");
				 break;
				 
			 case "Budapest":
				 System.out.println("Nem Talaltad el, nem Budapest!");
				 break;
				 
			 case "Bukarest" :
				 System.out.println("Nem Talaltad el, nem Bukarest!");
				 break;
			 
			 case "Berlin" :
				 Pontszam++;
				 System.out.println("Gratulalok eltalaltad Berlin! Van mar " + Pontszam + " pontod");
				 futas = false;
				 break;
				
			 default:
					 System.out.println("A listabol valasz kisuborka");
			 }
					 talalat++;
				 
				 if (talalat == 2 && Pontszam < 1) { 
				System.out.println("Sajnalom mar " + talalat + " talalgattal, jojon a kovetkezo kerdes");
					 futas = false;
					 break;
					 
					}
					
			 }
		 
					 System.out.println("--------------------------------------------------");
					 
					 futas = true;
					 
					 System.out.println("Valasz Egy Fizikust");
					 System.out.println("Neumann, Weigner, Teller, Albert");	 
					 talalat = 0;
					 
					 while(futas) {
						 String text = input.nextLine();  
						 switch(text) {
						 case "Neumann":
							 System.out.println("Nem Talaltad el, nem Neumann!");
							 break;
							 
						 case "Weigner":
							 System.out.println("Nem Talaltad el, nem Weigner!");
							 break;
							 
						 case "Teller" :
							 System.out.println("Nem Talaltad el, nem Teller!");
							 break;
						 
						 case "Albert" :
							 Pontszam++;
							 System.out.println("Gratulalok eltalaltad Albert! Van mar " + Pontszam + " pontod");
							 futas = false;
							 break;
							
						 default:
								 System.out.println("A listabol valasz kisuborka");
						 }
						 talalat++;
							 
						 if (talalat == 2 && Pontszam < 2) { 
								 System.out.println("Sajnalom mar " + talalat + " talalgattal, Game Over");
								 futas = false;
								 
								  }
		 }
					 System.out.println("Lett "+ Pontszam+ " Pontod");		

	}

}
