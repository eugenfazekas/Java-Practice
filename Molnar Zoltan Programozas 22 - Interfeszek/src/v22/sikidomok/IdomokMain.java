package v22.sikidomok;

import v22.pontok.Pont;
import v22.pontok.SikPont;

public class IdomokMain {

	public static void main(String[] args) {
	Pont a  = new SikPont(0,0);
	Pont b  = new SikPont(0,3);
	Pont c  = new SikPont(4,0);
	Pont d  = new SikPont(4,3);
	Pont e  = new SikPont(2,4);
	
	Haromszog derekszoguharomszog = new Haromszog(a,b,c);
	System.out.println("Derek: " + derekszoguharomszog.terulet());
	
	Teglalap teglalap = new Teglalap (a,b,c,d);
	System.out.println("Tegla: " + teglalap.terulet());
	
	Haromszog altalanosHaromszog = new Haromszog(a,e,c);
	System.out.println("Altalanos: "+ altalanosHaromszog.terulet());
	
	}
	
	public static Sikidom legnagyobbTeruletu(Sikidom[] sikidomok) {
		if(sikidomok.length == 0) {
			return null;
		}
		
		Sikidom legnagyobb = sikidomok[0];
		
		for(int i = 1 ; i< sikidomok.length; i++) {
			if(sikidomok[i].terulet()>legnagyobb.terulet()) {
				legnagyobb = sikidomok[i];
			}
		}
		return legnagyobb;
	}

}
