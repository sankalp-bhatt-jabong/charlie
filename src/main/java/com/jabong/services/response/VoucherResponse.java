package com.jabong.services.response;

import java.lang.reflect.InvocationTargetException;
import com.jabong.services.ConditionsRuleSet;
import com.jabong.models.Voucher;
import com.jabong.services.response.fields.voucher.VoucherDetail;

public class VoucherResponse extends BaseResponse {

	public VoucherResponse(Voucher voucher) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		VoucherDetail vFields = new VoucherDetail();
		ConditionsRuleSet cr = null;
		vFields.setId_sales_rule_set(voucher.getId());
		cr = new ConditionsRuleSet(voucher.getConditionsRuleset());
		vFields.setConditions_ruleset(cr);
		vFields.setDiscount_type(voucher.getDiscountType());
		vFields.setDiscount_percentage(voucher.getDiscountPercentage());
		vFields.setDiscount_amount_default(voucher.getDiscountAmountDefault());
		this.setData(vFields);
		this.setStatus(true);
	}

}