package com.ryankhan.menu;

import java.io.IOException;
import java.util.Scanner;

public class UserInput{
	private static final Scanner in = new Scanner(System.in);
	
	public static Scanner getScanner() {
		return in;
	}
	
	public static String getInput() throws IOException{
		String response = in.nextLine();
		return response;
	}

}
