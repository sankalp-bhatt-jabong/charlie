package com.jabong.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.services.response.BaseResponse;

public class AppController {
	
	@RequestMapping("*")
	@ResponseBody
	public BaseResponse fallbackMethod() {
		BaseResponse response = new BaseResponse();
		response.setData("Page Not Found");
		response.setStatus(false);
		return response;
	}
}