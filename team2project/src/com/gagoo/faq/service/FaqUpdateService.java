package com.gagoo.faq.service;

import com.gagoo.faq.dao.FaqDAO;
import com.gagoo.faq.vo.FaqVO;
import com.gagoo.util.io.Out;

public class FaqUpdateService{


	public Integer service(FaqVO vo) throws Exception {
		
		
		Out.header("FAQ 수정");
		FaqDAO dao = new FaqDAO();
		
		return dao.update(vo);
	
}
}
