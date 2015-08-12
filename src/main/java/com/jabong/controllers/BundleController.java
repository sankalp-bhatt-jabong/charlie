package com.jabong.controllers;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.JabongBus;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.BundleDetailResponse;
import com.jabong.services.response.BundleListResponse;
import com.jabong.services.response.BundlesOfSkuResponse;
import com.jabong.services.response.Sku2BundleMapResponse;
import com.jabong.services.util.SeaLogger;

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
	
	private SeaLogger log = SeaLogger.getInstance();

	@RequestMapping("/list")
	public @ResponseBody BaseResponse list() throws Exception {
		BaseResponse response = new BaseResponse();
		String skucode = request.getParameter("sku");
		if (StringUtils.isBlank(skucode)) {
			List<Bundle> bundles = bundleDao.fetchActiveList();
			response = new BundleListResponse(bundles);
		} else {
			List<?> bundleIds = (List<?>) bundleDao.getBundlesOfSku(skucode);
			response = new BundlesOfSkuResponse(bundleIds);
		}
		return response;
	}

	@RequestMapping("/detail")
	public @ResponseBody Object detail() throws Exception {
		BaseResponse response = new BaseResponse();
		String id = request.getParameter("id");
		String displaySku = request.getParameter("displaySku");
		if (StringUtils.isBlank(id)) {
			throw new Exception("Please Supply valid parameter value.");
		}
		if (StringUtils.isBlank(displaySku)) {
			displaySku = "0";
		}
		int bundleId = Integer.valueOf(id);
		Boolean displaysku = (Integer.valueOf(displaySku) == 1);
		Bundle bundle = bundleDao.getDetailById(bundleId, displaysku);
		if (bundle == null) {
			throw new Exception("Bundle Not Found.");
		}
		response = new BundleDetailResponse(bundle, displaysku);
		return response;
	}

	@RequestMapping("/sku-bundle-map")
	public @ResponseBody Object skuBundleMap() throws Exception{
		BaseResponse response = new BaseResponse();
		List<?> rowsList = bundleDao.getReverseSkuBundleMap();
		response = new Sku2BundleMapResponse(rowsList);
		return response;
	}
	
	@RequestMapping("/test")
	public @ResponseBody Object test() throws Exception{
		BaseResponse response = new BaseResponse();
		//Logger.getLogger(BundleController.class).error("sfdsfsf");
		//jabongBus.publish();
		log.getUtilityLogger().debug("hey there");
		log.getExceptionLogger().error("hey there");
		//bundleDao.getReverseSkuBundleMap();
		return response;
	}
	
	
	
	
	
	
	
	
}
