package com.gagoo.faq.controller;

import com.gagoo.faq.service.FaqDeleteService;
import com.gagoo.faq.service.FaqListService;
import com.gagoo.faq.service.FaqUpdateService;
import com.gagoo.faq.service.FaqViewService;
import com.gagoo.faq.service.FaqWriteService;
import com.gagoo.faq.vo.FaqVO;
import com.gagoo.main.Controller;
import com.gagoo.util.io.Input;
import com.gagoo.util.io.Out;
import com.gagoo.veiws.faq.FaqPrint;

public class FaqController implements Controller{

	@Override
	public void execute() {
		try {
			while (true) {
				// 현재 위치 출력
				Out.header("FAQ 게시판");
				// 메뉴출력
				Out.menuOut("-", 29, "1. FAQ리스트  2. FAQ보기  3. FAQ등록", "4. FAQ수정  5. FAQ삭제  0. 이전메뉴");

				// 메뉴 입력
				String menu = Input.scStr("메뉴를 선택해 주세요");

				// 입력 처리(이동,예외,종료)
				switch (menu) {
				case "1":
//				FaqService.faqService(new FaqListService());
					FaqListService faqListService = new FaqListService();

					FaqPrint.list(faqListService.service());
					break;
				case "2":

					Long no = Input.scLong("글번호를 입력 -> ");
					FaqViewService faqViewService = new FaqViewService();

					FaqPrint.view(faqViewService.service(no));
					break;
				case "3":
					FaqWriteService faqWriteService = new FaqWriteService();
					
					FaqVO vo = writeVO();
					
					faqWriteService.service(vo);
					break;
				case "4":
					
					//수정
//				FaqService.faqService(new FaqUpdateService());
				//1. 숫자입력 (리스트 먼저확인 필요)
					Out.header("글번호를 확인해주세요");
					no = Input.scLong("글 번호를 입력해주세요");

					//2. 해당하는 글 보기
					faqViewService = new FaqViewService();
					vo = faqViewService.service(no);
					
					//3. 수정 내용 입력
					updateVO(vo);
					
					//4. 내용 db에 반영 or 취소
					FaqUpdateService faqUpdateService = new FaqUpdateService();
					faqUpdateService.service(vo);
					
					break;
				case "5":
//				FaqService.faqService(new FaqDeleteService());
					//1. 삭제 글번호 입력 (리스트 먼저 확인 필요)
					Out.header("글번호를 확인해주세요");
					no = Input.scLong("글 번호를 입력해주세요");

					//2. 번호 dao 로 전달
					FaqDeleteService faqDeleteService = new FaqDeleteService();
					//3. dao에서 db에 삭제 쿼리 실행
					faqDeleteService.service(no);
					
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
	
	private void setTitle(FaqVO vo) {
		vo.setTitle(Input.scStr("제목"));
	}
	private void setContent(FaqVO vo) {
		vo.setContent(Input.scStr("내용"));
	}
	private void setWriter(FaqVO vo) {
		vo.setWriter(Input.scStr("작성자"));
	}

	private FaqVO writeVO() {
		FaqVO vo = new FaqVO();
		setTitle(vo);
		setContent(vo);
		setWriter(vo);
		return vo;
	}
	
	private void updateVO(FaqVO vo) throws Exception {
		while(true) {
		FaqPrint.view(vo);
		String menu = Input.scStr("1. 제목  2. 내용  3. 작성자  9. 수정  0. 취소");
		
		switch (menu) {
		
		case "1":
			setTitle(vo);
			break;
		case "2":
			setContent(vo);
			break;
		case "3":
			setWriter(vo);
			break;
		case "9":
			return;
			
		case "0":
			throw new Exception("수정 취소");

		default:
			System.out.println("올바른 메뉴를 선택해 주세요");
			break;
		}
		
		}
	}
}
