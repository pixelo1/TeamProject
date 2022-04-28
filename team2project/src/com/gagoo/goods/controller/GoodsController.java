package com.gagoo.goods.controller;

import com.gagoo.main.Controller;
import com.gagoo.util.io.Out;

public class GoodsController implements Controller{

	@Override
	public void execute() {
		Out.header("제품상세 게시판");
	}
}
