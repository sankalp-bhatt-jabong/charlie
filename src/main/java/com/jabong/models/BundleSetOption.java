package com.jabong.models;

import java.util.Set;

public class BundleSetOption {
	
	private Integer id;
	private Integer fkSkuBundleSets;
	private String sku;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFkSkuBundleSets() {
		return fkSkuBundleSets;
	}
	public void setFkSkuBundleSets(Integer fkSkuBundleSets) {
		this.fkSkuBundleSets = fkSkuBundleSets;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
		
}
