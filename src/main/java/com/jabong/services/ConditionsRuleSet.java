package com.jabong.services;

import java.util.Map;

public class ConditionsRuleSet{
	private Boolean Subtotal;
	private Map Category;
	private Boolean CapOnDiscount;
	private Map SkuExclude;
	private String DiscountedItem;
	private Map TaggedItem;
	private Map SegmentedVoucher;
	private Map Bundle;
	private Map MobileVoucher;
	private String pdp_segment_text;
	
	public ConditionsRuleSet (String conditionsRuleSet) {
		Map result = null;
		SerializedPhpParser serializedPhpParser = new SerializedPhpParser(
				conditionsRuleSet);
		result = (Map)serializedPhpParser.parse();
		Map sv = (Map)result.get("SegmentedVoucher");
		this.setSegmentedVoucher(sv);
		this.setPdp_segment_text((String)sv.get("pdp_segment_text"));
	    this.setDiscountedItem((String)result.get("DiscountedItem"));
	}
	
	
	public String getPdp_segment_text() {
		return pdp_segment_text;
	}
	public void setPdp_segment_text(String pdp_segment_text) {
		this.pdp_segment_text = pdp_segment_text;
	}
	
	public Boolean getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(Boolean subtotal) {
		Subtotal = subtotal;
	}
	public Map getCategory() {
		return Category;
	}
	public void setCategory(Map category) {
		Category = category;
	}
	public Boolean getCapOnDiscount() {
		return CapOnDiscount;
	}
	public void setCapOnDiscount(Boolean capOnDiscount) {
		CapOnDiscount = capOnDiscount;
	}
	public Map getSkuExclude() {
		return SkuExclude;
	}
	public void setSkuExclude(Map skuExclude) {
		SkuExclude = skuExclude;
	}
	public String getDiscountedItem() {
		return DiscountedItem;
	}
	public void setDiscountedItem(String discountedItem) {
		DiscountedItem = discountedItem;
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
		return Bundle;
	}
	public void setBundle(Map bundle) {
		Bundle = bundle;
	}
	public Map getMobileVoucher() {
		return MobileVoucher;
	}
	public void setMobileVoucher(Map mobileVoucher) {
		MobileVoucher = mobileVoucher;
	}
	
	
}