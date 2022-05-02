package com.gagoo.faq.service;

import java.util.List;

import com.gagoo.faq.dao.FaqDAO;
import com.gagoo.faq.vo.FaqVO;
import com.gagoo.util.io.Out;

public class FaqListService {

	public List<FaqVO> service() throws Exception {
		
		Out.header("FAQ 리스트");
		
		FaqDAO dao = new FaqDAO();
		return dao.list();
	
}
}
