package hw250507.Programing03;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TokenPrintTest {
	
	public static void main(String[] args) {
		String s = "of the people, by the people, for the people";
		
		try {
			showTokens(s, ", ");
		} catch (NoSuchElementException e){
			System.out.println("끝");
		}
	}
	static void showTokens(String s, String n) {
		StringTokenizer ST = new StringTokenizer(s, n);
		while(true) {
			String Token = ST.nextToken();
			System.out.println(Token);
		}
	}
}
