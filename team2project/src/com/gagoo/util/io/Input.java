package com.gagoo.util.io;

import java.util.Scanner;

public class Input {

	
	public static Scanner  scanner = new Scanner(System.in);
	
	public static String scannerIn(String str) {
		System.out.println(str);
		return scanner.nextLine();
	}
}
