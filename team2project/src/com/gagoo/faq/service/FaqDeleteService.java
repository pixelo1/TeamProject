package com.gagoo.faq.service;

import com.gagoo.faq.dao.FaqDAO;
import com.gagoo.util.io.Out;

public class FaqDeleteService {



	public Integer service(long no) throws Exception {
		
		Out.header("FAQ 삭제");
			
		FaqDAO dao = new FaqDAO();
		
		return dao.delete(no);
		
	
}
}
