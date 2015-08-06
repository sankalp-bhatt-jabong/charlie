package com.jabong.models;

import java.util.Set;

public class BundleSet {

	private Integer id;
	private Integer fkSkuBundle;
	private String label;
	private String discountApplicableOn;
	private String operator;
	private Integer quantity;
	private String actionSerialized;

	private Set<BundleSetOption> bundleSetOptions;

	public Set<BundleSetOption> getBundleSetOptions() {
		return bundleSetOptions;
	}

	public void setBundleSetOptions(Set<BundleSetOption> bundleSetOptions) {
		this.bundleSetOptions = bundleSetOptions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkSkuBundle() {
		return fkSkuBundle;
	}

	public void setFkSkuBundle(Integer fkSkuBundle) {
		this.fkSkuBundle = fkSkuBundle;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDiscountApplicableOn() {
		return discountApplicableOn;
	}

	public void setDiscountApplicableOn(String discountApplicableOn) {
		this.discountApplicableOn = discountApplicableOn;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getActionSerialized() {
		return actionSerialized;
	}

	public void setActionSerialized(String actionSerialized) {
		this.actionSerialized = actionSerialized;
	}

}
