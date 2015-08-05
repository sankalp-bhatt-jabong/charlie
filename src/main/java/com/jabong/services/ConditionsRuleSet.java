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
	private String taggeditem;
	private String tagvalue;
	private String promo_text;
	private String pdp_info_text;
	private Map SegmentedVoucher;
	private String segmentedvoucher_checkbox;
	private String segment_landing_url;
	private String pdp_segment_text;
	private Map bundle;
	private Map MobileVoucher;
	private String mobilevoucher_app;
	private String mobilevoucher_site;
	private String mobilevoucher_desktop;

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
			if (sv.containsKey("pdp_segment_text")) {
				this.setPdp_segment_text((String) sv.get("pdp_segment_text"));
			}
			if (sv.containsKey("segment_landing_url")) {
				this.setSegment_landing_url((String) sv
						.get("segment_landing_url"));
			}
			if (sv.containsKey("segmentedvoucher_checkbox")) {
				this.setSegmentedvoucher_checkbox((String) sv
						.get("segmentedvoucher_checkbox"));
			}
		}

		if (result.containsKey("Category")) {
			this.setCategory((Map) result.get("Category"));
		}

		if (result.containsKey("Customer")) {
			this.setCustomer((String) result.get("Customer"));
		}

		if (result.containsKey("Paymentmethod")) {
			if (result.get("Paymentmethod").equals(false)) {
				this.setPaymentMethod(Collections.emptyMap());
			} else {
				this.setPaymentMethod((Map) result.get("Paymentmethod"));
			}
		}

		if (result.containsKey("SkuExclude")) {
			this.setSkuExclude((Map) result.get("SkuExclude"));
		}

		if (result.containsKey("Bundle")) {
			if (result.get("Bundle").equals(false)) {
				this.setBundle(Collections.emptyMap());
			} else {
				this.setBundle((Map) result.get("Bundle"));
			}
		}
		
		if(result.containsKey("Discounted")) {
			int value;
			if ((result.get("Discounted").equals(false))) {
				value = 0;
			} else {
				value = Integer.parseInt((String) result.get("Discounted"));
			}
			// int i =(Boolean) result.get("DiscountedItem") ?
			// (Integer)result.get("DiscountedItem") : 0;
			this.setDiscounted(value);
		}

		if (result.containsKey("CapOnDiscount")) {
			if (result.get("CapOnDiscount").equals(false)) {
				this.setCapOnDiscount(Collections.emptyMap());
			} else {
				this.setCapOnDiscount((Map) result.get("CapOnDiscount"));
			}
		}

		if (result.containsKey("MobileVoucher")) {
			Map mv = (Map) result.get("MobileVoucher");
			this.setMobileVoucher(mv);
			if (mv.containsKey("mobilevoucher_app")) {
				this.setMobilevoucher_app((String) mv.get("mobilevoucher_app"));
			}
			if (mv.containsKey("mobilevoucher_site")) {
				this.setMobilevoucher_site((String) mv
						.get("mobilevoucher_site"));
			}
			if (mv.containsKey("mobilevoucher_desktop")) {
				this.setMobilevoucher_desktop((String) mv
						.get("mobilevoucher_desktop"));
			}
		}

		if (result.containsKey("TaggedItem")) {
			Map ti = (Map) result.get("TaggedItem");
			this.setTaggedItem(ti);
			if (ti.containsKey("taggeditem")) {
				this.setTaggeditem((String) ti.get("taggeditem"));
			}
			if (ti.containsKey("tagvalue")) {
				this.setTagvalue((String) ti.get("tagvalue"));
			}
			if (ti.containsKey("promo_tex")) {
				this.setPromo_text((String) ti.get("promo_tex"));
			}
			if (ti.containsKey("pdp_info_text")) {
				this.setPdp_info_text((String) ("pdp_info_text"));
			}
		}

		if (result.containsKey("DiscountedItem")) {
			int value;
			if ((result.get("DiscountedItem").equals(false))) {
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
			if ((result.get("Subtotal").equals(false))) {
				value = 0;
			} else {
				value = Integer.parseInt((String) result.get("Subtotal"));
			}
			this.setSubtotal(value);
		}
	}

	public String getPdp_segment_text() {
		return pdp_segment_text;
	}

	public void setPdp_segment_text(String pdp_segment_text) {
		this.pdp_segment_text = pdp_segment_text;
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

	public String getTaggeditem() {
		return taggeditem;
	}

	public void setTaggeditem(String taggeditem) {
		this.taggeditem = taggeditem;
	}

	public String getTagvalue() {
		return tagvalue;
	}

	public void setTagvalue(String tagvalue) {
		this.tagvalue = tagvalue;
	}

	public String getPromo_text() {
		return promo_text;
	}

	public void setPromo_text(String promo_text) {
		this.promo_text = promo_text;
	}

	public String getPdp_info_text() {
		return pdp_info_text;
	}

	public void setPdp_info_text(String pdp_info_text) {
		this.pdp_info_text = pdp_info_text;
	}

	public String getSegmentedvoucher_checkbox() {
		return segmentedvoucher_checkbox;
	}

	public void setSegmentedvoucher_checkbox(String segmentedvoucher_checkbox) {
		this.segmentedvoucher_checkbox = segmentedvoucher_checkbox;
	}

	public String getSegment_landing_url() {
		return segment_landing_url;
	}

	public void setSegment_landing_url(String segment_landing_url) {
		this.segment_landing_url = segment_landing_url;
	}

	public String getMobilevoucher_app() {
		return mobilevoucher_app;
	}

	public void setMobilevoucher_app(String mobilevoucher_app) {
		this.mobilevoucher_app = mobilevoucher_app;
	}

	public String getMobilevoucher_site() {
		return mobilevoucher_site;
	}

	public void setMobilevoucher_site(String mobilevoucher_site) {
		this.mobilevoucher_site = mobilevoucher_site;
	}

	public String getMobilevoucher_desktop() {
		return mobilevoucher_desktop;
	}

	public void setMobilevoucher_desktop(String mobilevoucher_desktop) {
		this.mobilevoucher_desktop = mobilevoucher_desktop;
	}

}