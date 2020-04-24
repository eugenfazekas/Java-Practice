package v33;

import java.util.Arrays;

public class Tarolo<T extends Comparable<T>> {

	private Elem <T> elso;
	
	private Elem <T> utolso;
	
	private int elemekSzama =0;
	
	public void hozzaadasAVegere(T tartalom) {
		Elem<T> ujElem = new Elem<T>(tartalom); 
			if(elso == null) {
				elso = ujElem;
			}
			if(utolso == null) {
				utolso = ujElem;
			}else {
				utolso.setKovetkezo(ujElem);
				ujElem.setElozo(utolso);
				utolso = ujElem;
			}
			elemekSzama++;
	}
	
	public void hozzaadasAzElejere(T szoveg) {
		Elem<T> ujElem = new Elem<T>(szoveg); 
			if(elso == null) {
				elso = ujElem;
			}else {
				elso.setElozo(ujElem);
				ujElem.setKovetkezo(elso);
				elso = ujElem;
			}
			if(utolso == null) {
				utolso = ujElem;
			}
			elemekSzama++;
	}

	public void torlesAVegerol() {
		if(utolso != null) {
			if(elso != null) {
				utolso = utolso.getElozo();
				utolso.setKovetkezo(null);
			}else {
				elso = null;
				utolso = null;
			}
		elemekSzama --;
		}
	}
	
	public T nedikElem(int index) {
		if(index >= elemekSzama) {
			throw new IndexOutOfBoundsException("A kert "+ index +" nagyob mint az elemek szama");
		}
		int i = 0;
		Elem<T> aktualis = elso;
		while(i<index) {
			aktualis = aktualis.getKovetkezo();
			i++;
		}
		return aktualis.getTartalom();
	}
	
	public void rendezes() {
		T[] atmenetiTomb = tombbeAlakitas();
		Arrays.sort(atmenetiTomb);
		feltoltesTombol(atmenetiTomb);
	}
	
	public int elemekSzama() {
		return elemekSzama;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		Elem<T> aktualis = elso;
		while (aktualis != null) {
			if(aktualis != elso) {
				sb.append(",");
			}
			sb.append(aktualis.getTartalom());
			aktualis = aktualis.getKovetkezo();
		}
		sb.append("]");
		return sb.toString();
	}
	
	private void feltoltesTombol(T[] tomb) {
		elemekSzama = tomb.length;
		Elem<T> elozo = null;
		for(int i = 0; i < elemekSzama; i++) {
			Elem<T> ujElem = new Elem<T>(tomb[i]);
			if(i==0) {
				elso = ujElem;
			}
			if(i == elemekSzama -1) {
				utolso = ujElem;
			}
			if(elozo != null) {
				ujElem.setElozo(elozo);
				elozo.setKovetkezo(ujElem);  
			}
		elozo = ujElem;
		}
	}
	
	private T[] tombbeAlakitas() {
		T[] tomb = (T[]) new Comparable[elemekSzama];
		int i = 0;
		Elem<T> aktualis = elso;
		while(aktualis != null) {
			T tartalom = aktualis.getTartalom();
			tomb[i++] = tartalom;
			aktualis = aktualis.getKovetkezo(); 
		}
	return tomb;
	}
}

