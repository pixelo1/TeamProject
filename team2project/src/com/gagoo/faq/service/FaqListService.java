package com.gagoo.faq.service;

import com.gagoo.faq.controller.Service;
import com.gagoo.faq.dao.FaqDAO;
import com.gagoo.util.io.Out;

public class FaqListService implements Service{

	@Override
	public void service() throws Exception {
		
		Out.header("FAQ 리스트");
		
		FaqDAO dao = new FaqDAO();
		dao.list();
	
}
}
