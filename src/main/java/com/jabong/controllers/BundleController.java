package com.jabong.controllers;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.notification.JabongBusMessage;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.BundleDetailResponse;
import com.jabong.services.response.BundleListResponse;
import com.jabong.services.response.BundleToSkuResponse;
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
		if (StringUtils.isBlank(id)) {
			throw new Exception("Please Supply valid parameter value.");
		}
		int bundleId = Integer.valueOf(id);
		Bundle bundle = bundleDao.getDetailById(bundleId);
		response = new BundleDetailResponse(bundle);
		return response;
	}

	@RequestMapping("/sku-bundle-map")
	public @ResponseBody Object skuBundleMap() throws Exception{
		BaseResponse response = new BaseResponse();
		List<?> rowsList = bundleDao.getReverseSkuBundleMap();
		response = new Sku2BundleMapResponse(rowsList);
		return response;
	}
	
    @RequestMapping("/bundle-sku-list")
    public @ResponseBody Object bundleSkulist() throws Exception
    {
        BaseResponse response = new BaseResponse();
        int id = Integer.parseInt(request.getParameter("id"));
        List<?> skuList = bundleDao.getBundleToSkuList(id);
        response = new BundleToSkuResponse(id, skuList);
        return response;
    }
	
}
