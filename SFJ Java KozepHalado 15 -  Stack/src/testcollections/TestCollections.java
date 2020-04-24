package testcollections;

import java.util.Stack;

public class TestCollections {

	public static void main(String[] args) {
		
		Stack<String> st = new Stack<String>();
		
		st.push("Legalja");
		st.push("Kozepe");
		st.push("Teteje");
		
		printStack(st);
		st.pop();

		printStack(st);
		st.pop();
		
		printStack(st);
		st.pop();

		printStack(st);
		
	}

	private static void printStack(Stack<String> st) {
		System.out.println(st.isEmpty() ? "A verem ures" : st.toString());
		
	}

}
