package com.gagoo.mypage.controller;

import com.gagoo.main.Controller;
import com.gagoo.util.io.Out;

public class MypageController implements Controller{

	@Override
	public void execute() {
		Out.header("마이페이지");
	}
}
