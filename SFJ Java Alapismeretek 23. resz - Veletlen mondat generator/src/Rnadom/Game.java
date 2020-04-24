package Rnadom;

public class Game {

	public String generator() { 
		
		String[] firstword = {"Nagyon jo","Megbizhato", "Kivalo","Tokeletes","A legeslegjobb"};
		String[] secondword = {"megoldas","legetoseg", "kivitelezes"};
		String[] thirdword = {"neked!","mindenkinek!", "az egesz vilagnak!","meg a foldonkivulieknek is!"};
	
		int random1 = (int) (Math.random() * firstword.length);
		int random2 = (int) (Math.random() * secondword.length);
		int random3 = (int) (Math.random() * thirdword.length);
		
		String sentence = firstword[random1] + " " + secondword[random2] + " " +thirdword[random3];
		
		return sentence;
 	}
	
}
