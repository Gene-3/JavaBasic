package app;

import java.util.Scanner;

public class MyAppReader {

	Scanner SC = new Scanner(System.in);
	
	public String readString(String message) {
		System.out.print(message);
		return SC.nextLine().strip();
	}
	
	public int readInt(String message) {
		System.out.print(message);
		return Integer.parseInt(SC.nextLine());
	}
}