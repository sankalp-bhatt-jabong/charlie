package com.jabong.services.response.fields.voucher;

public class PromotionVoucherFields {
	private int id_sales_rule_set;
	private String voucher_code;
	private String from_date;
	private String to_date;

	public int getId_sales_rule_set() {
		return id_sales_rule_set;
	}

	public void setId_sales_rule_set(int id_sales_rule_set) {
		this.id_sales_rule_set = id_sales_rule_set;
	}

	public String getVoucher_code() {
		return voucher_code;
	}

	public void setVoucher_code(String voucher_code) {
		this.voucher_code = voucher_code;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

}