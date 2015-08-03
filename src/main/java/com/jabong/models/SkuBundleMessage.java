package com.jabong.models;

import java.util.Set;

public class SkuBundleMessage {
	
	private Integer id;
	private Integer fkSkuBundle;
	private String messages;
	
	
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
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	

}
