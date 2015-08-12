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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
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
    public @ResponseBody Object test() throws Exception
    {
        String url = "http://bob.indfas-19445.qw/catalog-ext/webservice/update-price";
        String stringData = "{ \r\n\"context\" :  { \r\n\t\"uid\" : \"33er33\",   \r\n    \"email\" : \"tutu@jabong.com\",   \r\n    \"old_price_consistency\" : 0,\r\n    \"partial_execution_allowed\" : 0,\r\n    \"chunk_size\":3,\r\n    \"special_from_date\":\"2014-12-22\", \r\n    \"special_to_date\":\"2015-10-10\" \r\n}, \r\n\"columns\":[\r\n\t\"id_catalog_simple\",\r\n    \"special_price\"\r\n    \r\n], \r\n\"data\":[ \r\n[1, 300.00],\r\n[2, 300.00],\r\n[148, 1000.00]\r\n] \r\n}";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(url);
        httpost.setEntity(new StringEntity(stringData));
        HttpResponse response = httpclient.execute(httpost);
        if (response.getStatusLine().getStatusCode() != 200) {
           //throw an exception     
        }
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            //throw an exception
        }
        String responseData = EntityUtils.toString(entity);
        //@todo check if response is success
        return response.getStatusLine().getStatusCode();
    }
	
}
