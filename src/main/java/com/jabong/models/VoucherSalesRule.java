package com.jabong.models;

public class VoucherSalesRule {
	private int id;
	private Integer fkSalesRuleSet;
	private String code;
	private Boolean isActive;
	private Integer timesUsed;
	private String fromDate;
	private String toDate;
	private Float usedDiscountAmount;
	private String createdAt;
	private String updatedAt;
	private Integer fkCustomer;
	private Integer fkNewsletterSubscription;
	private Integer fkAclUser;
	private Float discountAmount;
	private Float modeOfDiscountAmount;
	private Float modeOfPaymentAmount;
	private Boolean isPublic;
	private String ip;
	private String deviceId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFkSalesRuleSet() {
		return fkSalesRuleSet;
	}

	public void setFkSalesRuleSet(Integer fkSalesRuleSet) {
		this.fkSalesRuleSet = fkSalesRuleSet;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getTimesUsed() {
		return timesUsed;
	}

	public void setTimesUsed(Integer timesUsed) {
		this.timesUsed = timesUsed;
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

	public Float getUsedDiscountAmount() {
		return usedDiscountAmount;
	}

	public void setUsedDiscountAmount(Float usedDiscountAmount) {
		this.usedDiscountAmount = usedDiscountAmount;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getFkCustomer() {
		return fkCustomer;
	}

	public void setFkCustomer(Integer fkCustomer) {
		this.fkCustomer = fkCustomer;
	}

	public Integer getFkNewsletterSubscription() {
		return fkNewsletterSubscription;
	}

	public void setFkNewsletterSubscription(Integer fkNewsletterSubscription) {
		this.fkNewsletterSubscription = fkNewsletterSubscription;
	}

	public Integer getFkAclUser() {
		return fkAclUser;
	}

	public void setFkAclUser(Integer fkAclUser) {
		this.fkAclUser = fkAclUser;
	}

	public Float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Float getModeOfDiscountAmount() {
		return modeOfDiscountAmount;
	}

	public void setModeOfDiscountAmount(Float modeOfDiscountAmount) {
		this.modeOfDiscountAmount = modeOfDiscountAmount;
	}

	public Float getModeOfPaymentAmount() {
		return modeOfPaymentAmount;
	}

	public void setModeOfPaymentAmount(Float modeOfPaymentAmount) {
		this.modeOfPaymentAmount = modeOfPaymentAmount;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}