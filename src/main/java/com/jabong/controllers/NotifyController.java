package com.jabong.controllers;



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
import com.jabong.services.notification.BundleNotify;
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
@RequestMapping("/notify")
public class NotifyController extends AppController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private BundleNotify bundleNotify;

	@RequestMapping("/bundle")
	public @ResponseBody Object bundle() {
		
		 bundleNotify.activeList();
		return "";
	}
	
	
	
	@RequestMapping("/test")
	public @ResponseBody Object test() {
		BaseResponse response = new BaseResponse();
		//jabongBus.publish();
		//SeaLogger.getInstance()
		//.getLogger(NotifyController.class).debug("hey there");
		//bundleDao.getReverseSkuBundleMap();
		return response;
	}
}
