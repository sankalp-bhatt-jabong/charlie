package com.jabong.services;

import java.util.Collections;
import java.util.Map;

public class ConditionsRuleSet {
	private int Subtotal;
	private Map Category;
	private String customer;
	private Map paymentMethod;
	private Map capOnDiscount;
	private Map SkuExclude;
	private int DiscountedItem;
	private int discounted;
	private Map TaggedItem;
	private Map SegmentedVoucher;
	private Map bundle;
	private Map brand;
	private Map MobileVoucher;
	private Map itemAttribute;

	public ConditionsRuleSet() {

	}

	public ConditionsRuleSet(String conditionsRuleSet) {
		Map result = null;
		SerializedPhpParser serializedPhpParser = new SerializedPhpParser(
				conditionsRuleSet);
		result = (Map) serializedPhpParser.parse();

		if (result.containsKey("SegmentedVoucher")) {
			Map sv = (Map) result.get("SegmentedVoucher");
			this.setSegmentedVoucher(sv);
		}

		if (result.containsKey("Category")) {
			this.setCategory((Map) result.get("Category"));
		}

		if (result.containsKey("Brand")) {
			this.setBrand((Map) result.get("Brand"));
		}
		if (result.containsKey("Customer")) {
			this.setCustomer((String) result.get("Customer"));
		}

		if (result.containsKey("Paymentmethod")) {
			if (result.get("Paymentmethod").equals(false) || result.get("Paymentmethod").equals("")
					|| result.get("Paymentmethod").equals("0")) {
				this.setPaymentMethod(Collections.emptyMap());
			} else {
				this.setPaymentMethod((Map) result.get("Paymentmethod"));
			}
		}

		if (result.containsKey("SkuExclude")) {
			this.setSkuExclude((Map) result.get("SkuExclude"));
		}

		if (result.containsKey("Bundle")) {
			if (result.get("Bundle").equals(false) ||result.get("Bundle").equals("0")
					|| result.get("Bundle").equals("")) {
				this.setBundle(Collections.emptyMap());
			} else {
				this.setBundle((Map) result.get("Bundle"));
			}
		}

		if (result.containsKey("Discounted")) {
			int value;
			if (result.get("Discounted").equals(false) || result.get("Discounted").equals("0")
					|| result.get("Discounted").equals("")) {
				value = 0;
			} else {
				value = Integer.parseInt((String) result.get("Discounted"));
			}
			// int i =(Boolean) result.get("DiscountedItem") ?
			// (Integer)result.get("DiscountedItem") : 0;
			this.setDiscounted(value);
		}

		if (result.containsKey("CapOnDiscount")) {
			if (result.get("CapOnDiscount").equals(false) || result.get("CapOnDiscount").equals("")
					|| result.get("CapOnDiscount").equals("0")) {
				this.setCapOnDiscount(Collections.emptyMap());
			} else {
				this.setCapOnDiscount((Map) result.get("CapOnDiscount"));
			}
		}

		if (result.containsKey("ItemAttribute")) {
			if (result.get("ItemAttribute").equals(false) || result.get("ItemAttribute").equals("")
					|| result.get("ItemAttribute").equals("0")) {
				this.setItemAttribute(Collections.emptyMap());
			} else {
				this.setItemAttribute((Map) result.get("ItemAttribute"));
			}
		}

		if (result.containsKey("MobileVoucher")) {
			Map mv = (Map) result.get("MobileVoucher");
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
			if (result.get("DiscountedItem").equals(false) || result.get("DiscountedItem").equals("")
					|| result.get("DiscountedItem").equals("0")) {
				value = 0;
			} else {
				value = Integer.parseInt((String) result.get("DiscountedItem"));
			}
			// int i =(Boolean) result.get("DiscountedItem") ?
			// (Integer)result.get("DiscountedItem") : 0;
			this.setDiscountedItem(value);
		}

		if (result.containsKey("Subtotal")) {
			int value;
			if (result.get("Subtotal").equals(false) || result.get("Subtotal").equals("0")
					|| result.get("Subtotal").equals("")) {
				value = 0;
			} else {
				value = Integer.parseInt((String) result.get("Subtotal"));
			}
			this.setSubtotal(value);
		}
	}

	public int getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(int subtotal) {
		Subtotal = subtotal;
	}

	public Map getCategory() {
		return Category;
	}

	public void setCategory(Map category) {
		Category = category;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Map getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Map paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Map getCapOnDiscount() {
		return capOnDiscount;
	}

	public void setCapOnDiscount(Map capOnDiscount) {
		this.capOnDiscount = capOnDiscount;
	}

	public Map getSkuExclude() {
		return SkuExclude;
	}

	public void setSkuExclude(Map skuExclude) {
		SkuExclude = skuExclude;
	}

	public int getDiscountedItem() {
		return DiscountedItem;
	}

	public void setDiscountedItem(int discountedItem) {
		DiscountedItem = discountedItem;
	}

	public int getDiscounted() {
		return discounted;
	}

	public void setDiscounted(int discounted) {
		this.discounted = discounted;
	}

	public Map getTaggedItem() {
		return TaggedItem;
	}

	public void setTaggedItem(Map taggedItem) {
		TaggedItem = taggedItem;
	}

	public Map getSegmentedVoucher() {
		return SegmentedVoucher;
	}

	public void setSegmentedVoucher(Map segmentedVoucher) {
		SegmentedVoucher = segmentedVoucher;
	}

	public Map getBundle() {
		return bundle;
	}

	public void setBundle(Map bundle) {
		this.bundle = bundle;
	}

	public Map getMobileVoucher() {
		return MobileVoucher;
	}

	public void setMobileVoucher(Map mobileVoucher) {
		MobileVoucher = mobileVoucher;
	}

	public Map getBrand() {
		return brand;
	}

	public void setBrand(Map brand) {
		this.brand = brand;
	}

	public Map getItemAttribute() {
		return itemAttribute;
	}

	public void setItemAttribute(Map itemAttribute) {
		this.itemAttribute = itemAttribute;
	}

}