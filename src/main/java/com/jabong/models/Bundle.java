package com.jabong.models;

public class Bundle {
	private Integer id;
	private Integer csvCount;
	private String name;
	private String displayName;
	private String description;
	private Integer isActive;
	private String fromDate;
	private String toDate;
	private String discountLevel;
	private String actionSerialized;
	private String freebieProducts;
	private Integer skipBundleCalculation;
	private String disabledPaymentMethod;
	private Integer isCheckoutDisabled;
	private Integer isDefaultMessageEnabled;
	private String defaultMessages;
	private String bundleBadge;
	private String bundleFilterText;
	
	
	public Integer getCsvCount() {
		return csvCount;
	}

	public void setCsvCount(Integer csvCount) {
		this.csvCount = csvCount;
	}

	public String getDiscountLevel() {
		return discountLevel;
	}

	public void setDiscountLevel(String discountLevel) {
		this.discountLevel = discountLevel;
	}

	public String getActionSerialized() {
		return actionSerialized;
	}

	public void setActionSerialized(String actionSerialized) {
		this.actionSerialized = actionSerialized;
	}

	public String getFreebieProducts() {
		return freebieProducts;
	}

	public void setFreebieProducts(String freebieProducts) {
		this.freebieProducts = freebieProducts;
	}

	public Integer getSkipBundleCalculation() {
		return skipBundleCalculation;
	}

	public void setSkipBundleCalculation(Integer skipBundleCalculation) {
		this.skipBundleCalculation = skipBundleCalculation;
	}

	public String getDisabledPaymentMethod() {
		return disabledPaymentMethod;
	}

	public void setDisabledPaymentMethod(String disabledPaymentMethod) {
		this.disabledPaymentMethod = disabledPaymentMethod;
	}

	public Integer getIsCheckoutDisabled() {
		return isCheckoutDisabled;
	}

	public void setIsCheckoutDisabled(Integer isCheckoutDisabled) {
		this.isCheckoutDisabled = isCheckoutDisabled;
	}

	public Integer getIsDefaultMessageEnabled() {
		return isDefaultMessageEnabled;
	}

	public void setIsDefaultMessageEnabled(Integer isDefaultMessageEnabled) {
		this.isDefaultMessageEnabled = isDefaultMessageEnabled;
	}

	public String getDefaultMessages() {
		return defaultMessages;
	}

	public void setDefaultMessages(String defaultMessages) {
		this.defaultMessages = defaultMessages;
	}

	public String getBundleBadge() {
		return bundleBadge;
	}

	public void setBundleBadge(String bundleBadge) {
		this.bundleBadge = bundleBadge;
	}

	public String getBundleFilterText() {
		return bundleFilterText;
	}

	public void setBundleFilterText(String bundleFilterText) {
		this.bundleFilterText = bundleFilterText;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
