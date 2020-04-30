package sor;

import java.util.PriorityQueue;
import java.util.Queue;

public class Sorballas {

	public static void main(String[] args) {
	
		Queue<String> qu = new PriorityQueue<>();
		qu.offer("Elso Gizi");
		System.out.println(qu);
		qu.offer("Masodik Gyula");
		System.out.println(qu);
		qu.offer("Harmadik Frodo");
		System.out.println(qu);
		
		qu.peek();
		System.out.println(qu.peek());
		
		qu.poll();
		System.out.println(qu);
		qu.offer("Csokos Jani");
		System.out.println(qu);
		qu.poll();
		System.out.println(qu);
		
	}
	
	

}
