package com.gagoo.faq.controller;

import com.gagoo.faq.service.FaqDeleteService;
import com.gagoo.faq.service.FaqListService;
import com.gagoo.faq.service.FaqUpdateService;
import com.gagoo.faq.service.FaqViewService;
import com.gagoo.faq.service.FaqWriteService;
import com.gagoo.main.Controller;
import com.gagoo.util.io.Input;
import com.gagoo.util.io.Out;

public class FaqController implements Controller{

	@Override
	public void execute() {
		try {
		while(true) {
			//현재 위치 출력
			Out.header("FAQ 게시판");
			//메뉴출력
			Out.menuOut("-", 29, "1. FAQ리스트  2. FAQ보기  3. FAQ등록", "4. FAQ수정  5. FAQ삭제  0. 이전메뉴");
			
			//메뉴 입력
			String menu = Input.scannerIn("메뉴를 선택해 주세요");
			
			//입력 처리(이동,예외,종료)
			switch (menu) {
			case "1":
				FaqService.faqService(new FaqListService());
				break;
			case "2":
				FaqService.faqService(new FaqViewService());
				break;
			case "3":
				FaqService.faqService(new FaqWriteService());
				break;
			case "4":
				FaqService.faqService(new FaqUpdateService());
				break;
			case "5":
				FaqService.faqService(new FaqDeleteService());
				break;
			case "0":
				System.out.println("이전메뉴");
				return;

			default:
				System.out.println("잘못된 메뉴 입력");
				break;
			
			}
			
		
	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
}
