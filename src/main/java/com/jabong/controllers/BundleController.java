package com.jabong.controllers;

import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.BundleListResponse;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/bundle")
public class BundleController extends AppController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private BundleDAO bundleDao;
	
	@RequestMapping("/list")
	public @ResponseBody BaseResponse list() {
		List<Bundle> bundles = bundleDao.fetchActiveList();
		BaseResponse response = new BundleListResponse(bundles);
		return response;
	}
	
	@RequestMapping("/detail")
	public @ResponseBody Object detail() {
		int bundleId = Integer.valueOf(request.getParameter("id"));
		Object bundle = bundleDao.getDetailById(bundleId);
		return bundle;
		
	}
	
	@RequestMapping("/test")
	public @ResponseBody String test() {
		Calendar c = Calendar.getInstance();
		String sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
		return sd;
		//return "sdsds";
	}

}
