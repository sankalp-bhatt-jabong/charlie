package com.jabong.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class AppController {
	
	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "404 not found here";
	}

}