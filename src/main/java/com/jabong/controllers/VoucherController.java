package com.jabong.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Voucher;
import com.jabong.models.dao.VoucherDAO;
import com.jabong.services.ConditionsRuleSet;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.VoucherResponse;
import com.jabong.services.response.fields.voucher.PromotionVoucherFields;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/voucher")
public class VoucherController extends AppController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private VoucherDAO voucherDao;

	@RequestMapping("/detail")
	public @ResponseBody BaseResponse detail(@RequestParam(value = "id") int id)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Voucher voucher = voucherDao.getDetailById(id);
		BaseResponse response = new VoucherResponse(voucher);
		return response;
	}

	@RequestMapping("/activeList")
	public @ResponseBody HashMap <String, Object> activeList() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		List<Object> vouchers = voucherDao.getActiveList();
		HashMap <String, Object> promotionVoucherDetail = new HashMap();   
		
		String salesRuleData = null;
		// BaseResponse response = new VoucherResponse(voucher);
		Iterator i = (Iterator)vouchers.iterator();
		while(i.hasNext()){
			Object[] obj =(Object[])i.next();
			int id = (Integer)obj[0];
			String crs = (String)obj[1];
			ConditionsRuleSet crsObj = new ConditionsRuleSet(crs);
			Map taggedItem = crsObj.getTaggedItem();
			if(!taggedItem.isEmpty()) {
				PromotionVoucherFields fields = new PromotionVoucherFields();
				if(taggedItem.containsKey("taggeditem")){
					String taggedItemValue =(String)taggedItem.get("taggeditem");
					if(taggedItemValue.equalsIgnoreCase("promotion")){
						salesRuleData = voucherDao.getSalesRuleData(id);
						fields.setId_sales_rule_set(id);
						fields.setVoucher_code(salesRuleData);
						String key = (String)taggedItem.get("tagvalue");
						promotionVoucherDetail.put(key, fields);
					}
				}
				
			}
			
		}
		return promotionVoucherDetail;
	}

}
