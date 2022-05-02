package com.gagoo.util.io;

import java.util.Scanner;

public class Input {

	
	public static Scanner  scanner = new Scanner(System.in);
	

	
	public static String sc() {
		return scanner.nextLine();
	}
	
	public static String scStr(String msg) {
		System.out.println(msg + "-> ");
		return sc();
	}
	
	
	public static Long scLong(String msg) {
		while (true) {
			try {
				String a = scStr(msg);
				return Long.parseLong(a);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자를 입력해주세요.");
			}
		}
		
	}
}
