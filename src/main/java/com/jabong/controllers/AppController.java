package com.jabong.controllers;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.services.response.BaseResponse;

public class AppController {
	
	@RequestMapping("*")
	@ResponseBody
	public void fallbackMethod() throws Exception {
		throw new Exception("Page not found");
	}
	/*
	@ExceptionHandler(Exception.class)
	public @ResponseBody BaseResponse exception(Exception e) {
		
		BaseResponse response = new BaseResponse();
		String message = "An exception occurred.";
		if (e instanceof JDBCConnectionException) {
		    message = "Connnection failed";
		}
		
		if (e.getMessage() != null) {
			message = e.getMessage();
		}
		response.setData(message);
		response.setStatus(false);
		return response;
	}*/
}