package com.jabong.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.jabong.services.util.StringUtil;

public class ConditionsRuleSet {
	private int subTotal;
	private Map<?,?> category;
	private String customer;
	private Map<?,?> paymentMethod;
	private Map<?,?> capOnDiscount;
	private Map<?,?> skuExclude;
	private int discountedItem;
	private int discounted;
	private Map<?,?> taggedItem;
	private Map<?,?> segmentedVoucher;
	private Map<?,?> bundle;
	private Map<?,?> brand;
	private Map<?,?> mobileVoucher;
	private Map<?,?> itemAttribute;

	public ConditionsRuleSet() {

	}

	public ConditionsRuleSet(String conditionsRuleSet) {
		Map<?,?> result = null;
		SerializedPhpParser serializedPhpParser = new SerializedPhpParser(
				conditionsRuleSet);
		result = (Map<?,?>) serializedPhpParser.parse();

		if (result.containsKey("SegmentedVoucher")) {
			Map<?,?> sv = (Map<?,?>) result.get("SegmentedVoucher");
			this.setSegmentedVoucher(sv);
		}

		if (result.containsKey("Category")) {
			this.setCategory((Map<?,?>) result.get("Category"));
		}

		if (result.containsKey("Brand")) {
			this.setBrand((Map<?,?>) result.get("Brand"));
		}
		if (result.containsKey("Customer")) {
			this.setCustomer((String) result.get("Customer"));
		}

		if (result.containsKey("Paymentmethod")) {
			Object attributeValue = result.get("Paymentmethod");
			if (StringUtil.empty(attributeValue)) {
				this.setPaymentMethod(Collections.emptyMap());
			} else {
				this.setPaymentMethod((Map<?,?>) attributeValue);
			}
		}

		if (result.containsKey("SkuExclude")) {
			this.setSkuExclude((Map<?,?>) result.get("SkuExclude"));
		}

		if (result.containsKey("Bundle")) {
			Object attributeValue = result.get("Bundle");
			if (StringUtil.empty(attributeValue)) {
				this.setBundle(Collections.emptyMap());
			} else if (attributeValue.equals("1")) {
				HashMap<String, String> bundle = new HashMap<String, String>();
				bundle.put("state", "exclude");
				this.setBundle(bundle);
			}
			else {
				this.setBundle((Map<?,?>) attributeValue);
			}
		}

		if (result.containsKey("Discounted")) {
			int value;
			Object attributeValue = result.get("Discounted");
			if (StringUtil.empty(attributeValue)) {
				value = 0;
			} else {
				value = Integer.parseInt((String) attributeValue);
			}

			this.setDiscounted(value);
		}

		if (result.containsKey("CapOnDiscount")) {
			Object attributeValue = result.get("CapOnDiscount");
			if (StringUtil.empty(attributeValue)) {
				this.setCapOnDiscount(Collections.emptyMap());
			} else {
				this.setCapOnDiscount((Map<?,?>) attributeValue);
			}
		}

		if (result.containsKey("ItemAttribute")) {

			Object attributeValue = result.get("ItemAttribute");
			if (StringUtil.empty(attributeValue)) {
				this.setItemAttribute(Collections.emptyMap());
			} else {
				this.setItemAttribute((Map<?,?>) attributeValue);
			}
		}

		if (result.containsKey("MobileVoucher")) {
			Map<String,Integer> mv = (Map)result.get("MobileVoucher");
			if (mv.containsKey("mobilevoucher_app")
					|| mv.containsKey("mobilevoucher_site")) {
				if (mv.containsKey("mobilevoucher_app")) {
					mv.put("mobilevoucher_app", 1);
				}
				if (mv.containsKey("mobilevoucher_site")) {
					mv.put("mobilevoucher_site", 1);
				}

			} else {

				mv.put("mobilevoucher_app", 1);
				mv.put("mobilevoucher_site", 1);
				mv.put("mobilevoucher_desktop", 1);
			}
			this.setMobileVoucher(mv);
		}

		if (result.containsKey("TaggedItem")) {
			Map ti = (Map) result.get("TaggedItem");
			this.setTaggedItem(ti);
		}

		if (result.containsKey("DiscountedItem")) {
			int value;
			Object attributeValue = result.get("DiscountedItem");
			if (StringUtil.empty(attributeValue)) {
				value = 0;
			} else {
				value = Integer.parseInt((String) attributeValue);
			}

			this.setDiscountedItem(value);
		}

		if (result.containsKey("Subtotal")) {
			int value;
			Object attributeValue = result.get("Subtotal");
			if (StringUtil.empty(attributeValue)) {
				value = 0;
			} else {
				value = Integer.parseInt((String) attributeValue);
			}

			this.setSubTotal(value);
		}
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public Map<?,?> getCategory() {
		return category;
	}

	public void setCategory(Map<?,?> category) {
		this.category = category;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Map<?,?> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Map<?,?> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Map<?,?> getCapOnDiscount() {
		return capOnDiscount;
	}

	public void setCapOnDiscount(Map<?,?> capOnDiscount) {
		this.capOnDiscount = capOnDiscount;
	}

	public Map<?,?> getSkuExclude() {
		return skuExclude;
	}

	public void setSkuExclude(Map<?,?> skuExclude) {
		this.skuExclude = skuExclude;
	}

	public int getDiscountedItem() {
		return discountedItem;
	}

	public void setDiscountedItem(int discountedItem) {
		this.discountedItem = discountedItem;
	}

	public int getDiscounted() {
		return discounted;
	}

	public void setDiscounted(int discounted) {
		this.discounted = discounted;
	}

	public Map<?,?> getTaggedItem() {
		return taggedItem;
	}

	public void setTaggedItem(Map<?,?> taggedItem) {
		this.taggedItem = taggedItem;
	}

	public Map<?,?> getSegmentedVoucher() {
		return segmentedVoucher;
	}

	public void setSegmentedVoucher(Map<?,?> segmentedVoucher) {
		this.segmentedVoucher = segmentedVoucher;
	}

	public Map<?,?> getBundle() {
		return bundle;
	}

	public void setBundle(Map<?,?> bundle) {
		this.bundle = bundle;
	}

	public Map<?,?> getMobileVoucher() {
		return mobileVoucher;
	}

	public void setMobileVoucher(Map<?,?> mobileVoucher) {
		this.mobileVoucher = mobileVoucher;
	}

	public Map<?,?> getBrand() {
		return brand;
	}

	public void setBrand(Map<?,?> brand) {
		this.brand = brand;
	}

	public Map<?,?> getItemAttribute() {
		return itemAttribute;
	}

	public void setItemAttribute(Map<?,?> itemAttribute) {
		this.itemAttribute = itemAttribute;
	}


}