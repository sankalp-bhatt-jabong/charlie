package com.jabong.controllers;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
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
import com.jabong.services.response.BundlesOfSkuResponse;
import com.jabong.services.response.Sku2BundleMapResponse;

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
		BaseResponse response = new BaseResponse();
		try {
			String skucode = request.getParameter("sku");
			if ((skucode == null) || (skucode.isEmpty())) {
				List<Bundle> bundles = bundleDao.fetchActiveList();
				response = new BundleListResponse(bundles);
			} else {
				List<?> bundleIds = (List<?>) bundleDao.geBundlesOfSku(skucode);
				response = new BundlesOfSkuResponse(bundleIds);
			}
		} catch (Exception e) {
			response.setData(e.getMessage());
			response.setStatus(false);
		}
		return response;
	}

	@RequestMapping("/detail")
	public @ResponseBody Object detail() {
		BaseResponse response = new BaseResponse();
		try {
			int bundleId = Integer.valueOf(request.getParameter("id"));
			Bundle bundle = bundleDao.getDetailById(bundleId);
			response = new BundleDetailResponse(bundle);
		} catch (Exception e) {
			response.setData(e.getMessage());
			response.setStatus(false);
		}
		return response;
	}

	@RequestMapping("/sku-bundle-map")
	public @ResponseBody Object skuBundleMap() {
		BaseResponse response = new BaseResponse();
		try {
		List<?> rowsList = bundleDao.getReverseSkuBundleMap();
		response = new Sku2BundleMapResponse(rowsList);
		} catch(Exception e) {
			response.setData(e.getMessage());
			response.setStatus(false);
		}
		return response;
	}
}
