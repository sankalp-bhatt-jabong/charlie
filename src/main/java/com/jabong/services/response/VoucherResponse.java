package com.jabong.services.response;

import java.util.List;
import java.util.ListIterator;

import com.jabong.models.SerializedPhpParser;
import com.jabong.models.Voucher;
import com.jabong.services.response.fields.voucher.VoucherDetail;

public class VoucherResponse extends BaseResponse {
	public VoucherResponse(List<Voucher> vouchers) {
		ListIterator<Voucher> voucherIterator = vouchers.listIterator();
		VoucherDetail vFields = new VoucherDetail();
		// ArrayList<SummaryFields> fields = new ArrayList<SummaryFields>();
		while (voucherIterator.hasNext()) {
			Voucher voucher = voucherIterator.next();
			// VoucherDetail vFields = new VoucherDetail();
			vFields.setId_sales_rule_set(voucher.getId());
			SerializedPhpParser serializedPhpParser = new SerializedPhpParser(
					voucher.getConditionsRuleset());
			Object result = serializedPhpParser.parse();
			vFields.setConditions_ruleset(result);
			vFields.setDiscount_type(voucher.getDiscountType());
			vFields.setDiscount_percentage(voucher.getDiscountPercentage());
		}
		this.setData(vFields);
		this.setStatus(true);
	}

}