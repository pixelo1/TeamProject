package com.gagoo.veiws.faq;

import java.util.List;

import com.gagoo.faq.vo.FaqVO;
import com.gagoo.util.io.Input;
import com.gagoo.util.io.Out;

public class FaqPrint {

	public static void list(List<FaqVO> list) throws Exception {
		
		if(list == null) {
			throw new Exception("데이터가 존재하지 않습니다.");
		}
		
		Out.header("게시판 리스트");
		Out.menuOut("-", 30, "번호 | 제목 | 작성자 | 작성일 | 조회수");
		
		for(FaqVO vo : list) {
		System.out.println(vo.getNo() +" | "+ vo.getTitle() +" | "+ vo.getWriter()
		+" | "+ vo.getWriteDate() +" | "+ vo.getHit());
		
		}
		
		
	}
	
	public static void view(FaqVO vo) throws Exception {
		
		if(vo == null) {
			throw new Exception("데이터가 존재하지 않습니다.");
		}
		Out.menuOut("-", 30, "먼저 게시판 리스트에서 글번호를 확인해 주세요.");
		
		Out.header("게시판 글보기");
		Out.symbol("-", 30);
		System.out.println(" + 번호 - " + vo.getNo());
		System.out.println(" + 제목 - " + vo.getTitle());
		System.out.println(" + 내용 - " + vo.getContent());
		System.out.println(" + 작성자 - " + vo.getWriter());
		System.out.println(" + 작성일 - " + vo.getWriteDate());
		System.out.println(" + 조회 - " + vo.getHit());
		Out.symbol("-", 30);		
		
	}
}
