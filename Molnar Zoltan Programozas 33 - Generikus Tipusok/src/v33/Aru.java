package v33;

import java.time.LocalDate;

public class Aru implements Comparable <Aru>{

	private String nev;
	
	private LocalDate szavatossag = LocalDate.now().plusMonths(1);
	
	private double mennyiseg = 1.0;
	
	private String mennyisegiEgyseg = "Kg";
	
	public Aru (String nev) {
		this.nev = nev;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public LocalDate getSzavatossag() {
		return szavatossag;
	}

	public void setSzavatossag(LocalDate szavatossag) {
		this.szavatossag = szavatossag;
	}

	public double getMennyiseg() {
		return mennyiseg;
	}

	public void setMennyiseg(double mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	public String getMennyisegiEgyseg() {
		return mennyisegiEgyseg;
	}

	public void setMennyisegiEgyseg(String mennyisegiEgyseg) {
		this.mennyisegiEgyseg = mennyisegiEgyseg;
	}

	@Override
	public int compareTo(Aru arg0) {
		
		return nev.compareTo(nev);
	}
	
}
