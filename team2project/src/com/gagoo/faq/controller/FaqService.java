package com.gagoo.faq.controller;

public class FaqService {

	public static void faqService(Service ser) throws Exception {
		
		System.out.println("-------실행 전 처리------");
		System.out.println("--------권한처리 -------");
		
		ser.service();
		
		System.out.println("-------실행 후 처리------");
	}
}
