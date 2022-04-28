package com.gagoo.main;

public class Execute {
	
	public static void controller(Controller cont) {
		
		System.out.println("실행 전 처리----");
		System.out.println("---권한처리--");
		//인터페이스 불러옴
		cont.execute();
		
		System.out.println("실행 후 처리----");
	}

}
