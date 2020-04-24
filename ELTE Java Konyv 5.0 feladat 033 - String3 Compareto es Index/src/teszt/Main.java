package teszt;

public class Main {

	public static void main(String[] args) {
		
	int i  ="alma".compareTo("alom"); 	System.out.println(i);
	
	int ii  ="alom".compareTo("alma"); 	System.out.println(ii);
	
	boolean b3 = "almafa".regionMatches(2, "MAFLA", 0, 3);
	
	boolean b4 = "almafa".regionMatches(true,2, "MAFLA", 0, 3); // IgnoreCAse ? true vagy false?
	
	System.out.println(b3); System.out.println(b4);
	
	int index1 = "kukuriku".indexOf('u'); //1
	int index2 = "kukuriku".indexOf('u',2); //3 hanyadik karaktertol keressun
	int index3 = "kukuriku".indexOf("ku"); //0
	int index4 = "kukuriku".indexOf("ku",4); //6 hanyadik karaktertol keressun 
	int index5 = "kukuriku".indexOf("kakas"); //-1
	
	int index6 = "kukuriku".lastIndexOf('u'); //1
	int index7 = "kukuriku".lastIndexOf('u',2); //3 hanyadik karaktertol keressun meg az utolsot
	int index8 = "kukuriku".lastIndexOf("ku"); //0
	int index9 = "kukuriku".lastIndexOf("ku",4); //6 hanyadik karaktertol keressun meg az utolsot
	int index10 = "kukuriku".lastIndexOf("kakas"); //-1
	
	boolean b5 = "alma.txt".startsWith("alma");   // true
	boolean b6 = "alma.txt".startsWith("alma",2); // false 
	
	
	}

}
