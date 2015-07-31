package com.jabong.controllers;

import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.response.*;
import com.jabong.services.response.fields.bundle.SummaryFields;


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
	public @ResponseBody List<SummaryFields> list() {
		List<Bundle> bundles = bundleDao.activeList();
		ListIterator<Bundle> bundleIterator = bundles.listIterator();
		Bundle bundle = null;
		ArrayList<SummaryFields> test = new ArrayList<SummaryFields>();
		while(bundleIterator.hasNext()) {
			bundle = (Bundle) bundleIterator.next();
			SummaryFields sFields = new SummaryFields();
			sFields.setId(bundle.getId());
			sFields.setDisplay_name(bundle.getDisplayName());
			test.add(sFields);
		}
		return test;
		
	}
	
	@RequestMapping("/test")
	public @ResponseBody String test() {
		Calendar c = Calendar.getInstance();
		String sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
		return sd;
		//return "sdsds";
	}
	
	

}
