package com.jabong.services.response.fields.bundle;

public class ActionSerializedFields {

	private String discount_mode;
	private String discount_value;
	private String discount_applicable_on;
	private Integer is_discount_distributed_proportionally;
	private String lower_items_number;
	private Integer is_minimum_price_value;
	private String min_price;

	public String getDiscount_mode() {
		return discount_mode;
	}

	public void setDiscount_mode(String discount_mode) {
		this.discount_mode = discount_mode;
	}

	public String getDiscount_value() {
		return discount_value;
	}

	public void setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
	}

	public String getDiscount_applicable_on() {
		return discount_applicable_on;
	}

	public void setDiscount_applicable_on(String discount_applicable_on) {
		this.discount_applicable_on = discount_applicable_on;
	}

	public Integer getIs_discount_distributed_proportionally() {
		return is_discount_distributed_proportionally;
	}

	public void setIs_discount_distributed_proportionally(
			Integer is_discount_distributed_proportionally) {
		this.is_discount_distributed_proportionally = is_discount_distributed_proportionally;
	}

	public String getLower_items_number() {
		return lower_items_number;
	}

	public void setLower_items_number(String lower_items_number) {
		this.lower_items_number = lower_items_number;
	}

	public Integer getIs_minimum_price_value() {
		return is_minimum_price_value;
	}

	public void setIs_minimum_price_value(Integer is_minimum_price_value) {
		this.is_minimum_price_value = is_minimum_price_value;
	}

	public String getMin_price() {
		return min_price;
	}

	public void setMin_price(String min_price) {
		this.min_price = min_price;
	}

}
