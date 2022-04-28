package com.gagoo.promotionboard.controller;

import com.gagoo.main.Controller;
import com.gagoo.util.io.Out;

public class PromotionBoardController implements Controller{

	@Override
	public void execute() {
		Out.header("프로모션 게시판");
	}
}
