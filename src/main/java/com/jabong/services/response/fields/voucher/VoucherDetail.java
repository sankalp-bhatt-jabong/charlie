package com.jabong.services.response.fields.voucher;

public class VoucherDetail {
	private int id_sales_rule_set;
	private Object conditions_ruleset;
	private String discount_type;
	private Float discount_percentage;
	private Float discount_amount_default;

	public int getId_sales_rule_set() {
		return id_sales_rule_set;
	}

	public void setId_sales_rule_set(int id_sales_rule_set) {
		this.id_sales_rule_set = id_sales_rule_set;
	}

	public Object getConditions_ruleset() {
		return conditions_ruleset;
	}

	public void setConditions_ruleset(Object conditions_ruleset) {
		this.conditions_ruleset = conditions_ruleset;
	}

	public String getDiscount_type() {
		return discount_type;
	}

	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public Float getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(Float discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public Float getDiscount_amount_default() {
		return discount_amount_default;
	}

	public void setDiscount_amount_default(Float discount_amount_default) {
		this.discount_amount_default = discount_amount_default;
	}

}