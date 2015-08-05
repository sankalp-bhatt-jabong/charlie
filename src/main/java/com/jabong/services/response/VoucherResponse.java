package com.jabong.services.response;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.jabong.services.ConditionsRuleSet;
import com.jabong.services.SerializedPhpParser;
import com.jabong.models.Voucher;
import com.jabong.services.response.fields.voucher.VoucherDetail;

public class VoucherResponse extends BaseResponse {

	public VoucherResponse(Voucher voucher) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		VoucherDetail vFields = new VoucherDetail();
		ConditionsRuleSet cr = null;
		vFields.setId_sales_rule_set(voucher.getId());
		Map result = null;
		//SerializedPhpParser serializedPhpParser = new SerializedPhpParser(
			//	voucher.getConditionsRuleset());
		//result = (Map) serializedPhpParser.parse();

		cr = new ConditionsRuleSet(voucher.getConditionsRuleset());
		//ConditionsRuleSet cr1 = new ConditionsRuleSet();
		vFields.setConditions_ruleset(cr);
		vFields.setDiscount_type(voucher.getDiscountType());
		vFields.setDiscount_percentage(voucher.getDiscountPercentage());
		vFields.setDiscount_amount_default(voucher.getDiscountAmountDefault());
		//vFields.setMobilevoucher_app(cr.getMobilevoucher_app());
		//vFields.setMobilevoucher_desktop(cr.getMobilevoucher_desktop());
		//vFields.setMobilevoucher_site(cr.getMobilevoucher_site());
		this.setData(vFields);
		this.setStatus(true);
	}

}