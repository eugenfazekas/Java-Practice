package v30;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("isLetter('@')= " + Character.isLetter('@'));
		
		String hello = "HeLlo!";
		
		String helloAgain = new String("Hello again here!");
		
		System.out.println("substring 6-11  "+helloAgain.substring(6,11));
		
		System.out.println("substring 5:-> "+helloAgain.substring(5));
		
		char[] letters = {'H','E','l','l','o','!'};
		
		String helloOnly = new String(letters);
		
		String hell = hello+helloOnly;
		
		System.out.println(hell);
		
		System.out.println("Pingvin "+"pingvin".equalsIgnoreCase("PingVin"));
		 
		System.out.println("Index of '!'" +hell.indexOf('!')); 
		
		System.out.println("Index of '!'" +helloAgain.indexOf("again")); 
		
		System.out.println("Betu\tNagy\tKicsi");
		for(int i = 0; i< hello.length(); i++) {
			char actualChar = hello.charAt(i);
			System.out.printf("%c\t%b\t%b\n",actualChar, Character.isUpperCase(actualChar), Character.isLowerCase(actualChar));
		}
		System.out.println();
		System.out.println("Betu\tNagy\tKicsi");
		for(int i = 0; i< hello.length(); i++) {
			char actualChar = hello.charAt(i);
			System.out.printf("%c\t%c\t%c\n",actualChar, Character.toLowerCase(actualChar), Character.toUpperCase(actualChar));
		}
		String palindrom = "Emis saw a slime";
		StringBuilder sb = new StringBuilder(palindrom);
		sb.reverse();
		System.out.println(sb);
		
	}

}
