package com.gagoo.faq.service;

import com.gagoo.faq.dao.FaqDAO;
import com.gagoo.faq.vo.FaqVO;
import com.gagoo.util.io.Out;

public class FaqWriteService {


	
	public void service(FaqVO vo) throws Exception {
		
		Out.header("FAQ 등록");
		FaqDAO dao = new FaqDAO();
		dao.write(vo);
			
		
	
}
}
