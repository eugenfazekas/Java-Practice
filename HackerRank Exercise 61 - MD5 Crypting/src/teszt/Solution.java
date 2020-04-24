package teszt;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");

		Scanner scan = new Scanner(System.in);
		
		String input = scan.next();
		
		byte[] byteOfInput = input.getBytes(StandardCharsets.UTF_8);
		
		byte[] byteOfOutput = md.digest(byteOfInput);
		
		
		StringBuilder sb = new StringBuilder();
		for(byte b : byteOfOutput)
			sb.append(String.format("%02x", b));
		System.out.print(sb);
		


	}

}
