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
	public @ResponseBody BaseResponse activeList()
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		List<Object> vouchers = voucherDao.getActiveList();
		HashMap<String, Object> promotionVoucherDetail = new HashMap();

		// String salesRuleData = null;
		// BaseResponse response = new VoucherResponse(voucher);
		BaseResponse response = new BaseResponse();
		Iterator i = (Iterator) vouchers.iterator();
		while (i.hasNext()) {
			Object[] obj = (Object[]) i.next();
			int id = (Integer) obj[0];
			String crs = (String) obj[1];
			ConditionsRuleSet crsObj = new ConditionsRuleSet(crs);
			Map taggedItem = crsObj.getTaggedItem();
			if (!taggedItem.isEmpty()) {
				PromotionVoucherFields fields = new PromotionVoucherFields();
				if (taggedItem.containsKey("taggeditem")) {
					String taggedItemValue = (String) taggedItem
							.get("taggeditem");
					if (taggedItemValue.equalsIgnoreCase("promotion")) {
						Object[] salesRuleData = (Object[]) voucherDao
								.getSalesRuleData(id);
						fields.setId_sales_rule_set(id);
						// String code = (String)salesRuleData[0];
						fields.setVoucher_code((String) salesRuleData[0]);
						fields.setFrom_date((String) salesRuleData[1]);
						fields.setTo_date((String) salesRuleData[2]);
						int key1 = Integer.parseInt((String) taggedItem
								.get("tagvalue"));
						String key = voucherDao.mapToTagValue(key1);
						promotionVoucherDetail.put(key, fields);
					}
				}

			}

		}
		// return promotionVoucherDetail;
		response.setData(promotionVoucherDetail);
		response.setStatus(true);
		return response;
	}

}
