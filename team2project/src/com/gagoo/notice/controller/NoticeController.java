package com.gagoo.notice.controller;

import com.gagoo.main.Controller;
import com.gagoo.util.io.Out;

public class NoticeController implements Controller{

	@Override
	public void execute() {
		Out.header("공지사항 게시판");
	}
}
