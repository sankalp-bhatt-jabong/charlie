package com.jabong.services.response;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jabong.models.dao.VoucherDAO;
import com.jabong.services.ConditionsRuleSet;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.fields.voucher.PromotionVoucherFields;

public class VoucherListResponse extends BaseResponse {

	public VoucherListResponse(List<Object> vouchers, VoucherDAO voucherDao)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		HashMap<String, Object> promotionVoucherDetail = new HashMap();
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
						if (salesRuleData != null && salesRuleData.length != 0) {
							fields.setId_sales_rule_set(id);
							// String code = (String)salesRuleData[0];
							fields.setVoucher_code((String) salesRuleData[0]);
							fields.setFrom_date(salesRuleData[1].toString()
									.replaceAll("\\.\\d+", ""));
							fields.setTo_date(salesRuleData[2].toString()
									.replaceAll("\\.\\d+", ""));
							int key1 = Integer.parseInt((String) taggedItem
									.get("tagvalue"));
							String key = voucherDao.mapToTagValue(key1);
							promotionVoucherDetail.put(key, fields);
						}
					}
				}

			}

		}
		this.setData(promotionVoucherDetail);
		this.setStatus(true);
	}
}
