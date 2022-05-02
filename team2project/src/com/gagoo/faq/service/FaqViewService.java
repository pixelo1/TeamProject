package com.gagoo.faq.service;

import com.gagoo.faq.dao.FaqDAO;
import com.gagoo.faq.vo.FaqVO;
import com.gagoo.util.io.Out;

public class FaqViewService{


	
	public FaqVO service(long no) throws Exception {
		
		Out.header("FAQ 보기");
		
			FaqDAO dao = new FaqDAO();
			return dao.view(no);
		
	
}
}
