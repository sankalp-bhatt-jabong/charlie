package com.jabong.controllers;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;


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
	public @ResponseBody List<Bundle> list() {
		List<Bundle> bundles = bundleDao.list();
		//Map<String, String[]> m = request.getParameterValues();
		return bundles;
		//return "sdsds";
	}

}
