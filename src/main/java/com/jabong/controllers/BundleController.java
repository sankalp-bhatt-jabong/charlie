package com.jabong.controllers;

import java.util.*;
import com.jabong.json.ActiveBundles;

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
	
	@RequestMapping("/activeList")
	public @ResponseBody ActiveBundles list() {
		ActiveBundles activeBundleList = new ActiveBundles();
		List<ActiveBundles> bundles = bundleDao.activeList();
		//Map<String, String[]> m = request.getParameterValues();
		Iterator i = bundles.iterator();
		ArrayList<Integer> listing = new ArrayList<Integer>();
		short status=1;
		while(i.hasNext()){
			Integer arr=(Integer)i.next();
			listing.add(arr.intValue());
		}
		activeBundleList.setData(listing);
		activeBundleList.setStatus(status);
		return activeBundleList;
		//return "sdsds";
	}

}
