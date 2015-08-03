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
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.BundleDetailResponse;
import com.jabong.services.response.BundleListResponse;
import com.jabong.services.response.Sku2BundleMapResponse;
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
	public @ResponseBody BaseResponse list() {
		List<Bundle> bundles = bundleDao.fetchActiveList();
		BaseResponse response = new BundleListResponse(bundles);
		return response;
	}
	
	@RequestMapping("/detail")
	public @ResponseBody Object detail() {
		int bundleId = Integer.valueOf(request.getParameter("id"));
		Bundle bundle = bundleDao.getDetailById(bundleId);
		BundleDetailResponse response = new BundleDetailResponse(bundle);
		return response;
		
	}
	
	@RequestMapping("/test")
	public @ResponseBody Object test() {
		Bundle bundle = bundleDao.getDetailById(22);
		return bundle;
		
	}
	
	@RequestMapping("/sku-bundle-map")
	public @ResponseBody Object skuBundleMap() {
		List<?> rowsList = bundleDao.getReverseSkuBundleMap();
		Object response = new Sku2BundleMapResponse(rowsList);
		return response;
	}

}
