package com.jabong.models;

public class Voucher{
	private int id;
	private String name;
	private String codePrefix;
	private Integer fkDepartmentId;
	private Integer fkAclUser;
	private String description;
	private Boolean isActive;
	private Float discountAmountDefault;
	private Integer fkSalesRuleSetRefund;
	private int durationInDays;
	private int usageLimit;
	private String type;
	private Integer fkSalesRuleSubtype;
	private Integer fkSalesRuleCampaign;
	private Boolean isRefundable;
	private String discountType;
	private Float discountPercentage;
	private short applyToShipping;
	private String conditionsRuleset;
	private int codeLength;
	private String bankName;
	private String offerCode;
	private short isDefaultMessageEnabled;
	private String messages;
	private String voucherMode;
	private Float modeOfDiscountAmount;
	private Float modeOfPaymentAmount;
	private String ip;
	private short showOnWebsite;
	private short showSegmentedOnWebsite;
	private Integer fkSystemDevice;
	private String domain;
	public Integer getFkDepartmentId() {
		return fkDepartmentId;
	}
	public void setFkDepartmentId(Integer fkDepartmentId) {
		this.fkDepartmentId = fkDepartmentId;
	}
	public Integer getFkAclUser() {
		return fkAclUser;
	}
	public void setFkAclUser(Integer fkAclUser) {
		this.fkAclUser = fkAclUser;
	}
	public Integer getFkSalesRuleSetRefund() {
		return fkSalesRuleSetRefund;
	}
	public void setFkSalesRuleSetRefund(Integer fkSalesRuleSetRefund) {
		this.fkSalesRuleSetRefund = fkSalesRuleSetRefund;
	}
	public Integer getFkSalesRuleSubtype() {
		return fkSalesRuleSubtype;
	}
	public void setFkSalesRuleSubtype(Integer fkSalesRuleSubtype) {
		this.fkSalesRuleSubtype = fkSalesRuleSubtype;
	}
	public Integer getFkSalesRuleCampaign() {
		return fkSalesRuleCampaign;
	}
	public void setFkSalesRuleCampaign(Integer fkSalesRuleCampaign) {
		this.fkSalesRuleCampaign = fkSalesRuleCampaign;
	}
	public Integer getFkSystemDevice() {
		return fkSystemDevice;
	}
	public void setFkSystemDevice(Integer fkSystemDevice) {
		this.fkSystemDevice = fkSystemDevice;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Float getDiscountAmountDefault() {
		return discountAmountDefault;
	}
	public void setDiscountAmountDefault(Float discountAmountDefault) {
		this.discountAmountDefault = discountAmountDefault;
	}
	
	public int getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}
	public int getUsageLimit() {
		return usageLimit;
	}
	public void setUsageLimit(int usageLimit) {
		this.usageLimit = usageLimit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Boolean getIsRefundable() {
		return isRefundable;
	}
	public void setIsRefundable(Boolean isRefundable) {
		this.isRefundable = isRefundable;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public Float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public short getApplyToShipping() {
		return applyToShipping;
	}
	public void setApplyToShipping(short applyToShipping) {
		this.applyToShipping = applyToShipping;
	}
	public String getConditionsRuleset() {
		return conditionsRuleset;
	}
	public void setConditionsRuleset(String conditionsRuleset) {
		this.conditionsRuleset = conditionsRuleset;
	}
	public int getCodeLength() {
		return codeLength;
	}
	public void setCodeLength(int codeLength) {
		this.codeLength = codeLength;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public short getIsDefaultMessageEnabled() {
		return isDefaultMessageEnabled;
	}
	public void setIsDefaultMessageEnabled(short isDefaultMessageEnabled) {
		this.isDefaultMessageEnabled = isDefaultMessageEnabled;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getVoucherMode() {
		return voucherMode;
	}
	public void setVoucherMode(String voucherMode) {
		this.voucherMode = voucherMode;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public short getShowOnWebsite() {
		return showOnWebsite;
	}
	public void setShowOnWebsite(short showOnWebsite) {
		this.showOnWebsite = showOnWebsite;
	}
	public short getShowSegmentedOnWebsite() {
		return showSegmentedOnWebsite;
	}
	public void setShowSegmentedOnWebsite(short showSegmentedOnWebsite) {
		this.showSegmentedOnWebsite = showSegmentedOnWebsite;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public int getId() {
		return id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCodePrefix() {
		return codePrefix;
	}
	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix;
	}
	
	
}