package Randommondtagenerator;

public class Random {

public  String genarator() {
	
	String[] napok = {"Hetfo ","Kedd ","Szerda ","Csutortok ","Pentek "};
	String[] ora = {"6:","7:","8:","9:"};
	String[] perc = {"00","10","20","30","40","50"};
	
	int random1 = (int) (Math.random() * napok.length);
	int random2 = (int) (Math.random() * ora.length);
	int random3 = (int) (Math.random() * perc.length);
	
	String mondat = napok[random1]+""+ora[random2]+""+perc[random3];
	return mondat;
}
	
}