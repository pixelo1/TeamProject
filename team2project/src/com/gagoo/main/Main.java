package com.gagoo.main;

import com.gagoo.Admin.controller.AdminController;
import com.gagoo.faq.controller.FaqController;
import com.gagoo.goods.controller.GoodsController;
import com.gagoo.mypage.controller.MypageController;
import com.gagoo.notice.controller.NoticeController;
import com.gagoo.promotionboard.controller.PromotionBoardController;
import com.gagoo.util.io.Input;
import com.gagoo.util.io.Out;

public class Main {

	public static void main(String[] args) {
		
		//환영
		System.out.println("GAGOO에 오신것을 환영합니다");
		
		
		while(true) {
		//현재 위치 출력
		Out.header("메인 메뉴");
		//메뉴출력
		Out.menuOut("-", 29, "1. 공지사항  2. 프로모션  3. 제품상세  4. 질문답변", "5. 회원관리  6. 마이페이지  0. 종료");
		
		//메뉴 입력
		String menu = Input.scStr("메뉴를 선택해 주세요");
		
		//입력 처리(이동,예외,종료)
		switch (menu) {
		case "1":
			Execute.controller(new NoticeController());
			break;
		case "2":
			Execute.controller(new PromotionBoardController());
			break;
		case "3":
			Execute.controller(new GoodsController());
			break;
		case "4":
			Execute.controller(new FaqController());
			break;
		case "5":
			Execute.controller(new AdminController());
			break;
		case "6":
			Execute.controller(new MypageController());
			break;
		case "0":
			System.out.println("종료");
			System.exit(0);

		default:
			System.out.println("잘못된 메뉴 입력");
			break;
		
		}
		
		
		}
		
	}

}
