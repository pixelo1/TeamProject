package com.gagoo.util.io;

public class Out {

	
	//특수문자 반복
	public static void symbol(String symbol, int num) {
		
		for(int i =0; i < num; i++ ) {
			System.out.print(symbol);
		}System.out.println();
	}
	
	//메뉴배열 반복
	public static void menuArrayPrint(String ...menu) {
		
		for (int i = 0; i < menu.length; i++) {
			
			System.out.println(menu[i]);
		}
		
	}
	
	//환영인사, 현재위치
	public static void header(String str) {
		System.out.println("===========" + str + "===========");
		
	}
	
	//파라미터값 넣으면 자동 출력 (메뉴출력)
	public static void menuOut(String symbol,int num, String ...menu){
		symbol(symbol, num);
		menuArrayPrint(menu);
		symbol(symbol, num);
	}
	
}
