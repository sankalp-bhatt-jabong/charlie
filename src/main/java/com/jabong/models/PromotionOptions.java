package com.jabong.models;

public class PromotionOptions {
	private int id;
	private String name;
	private String name_en;
	private Short position;
	private Boolean is_default;
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
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public Short getPosition() {
		return position;
	}
	public void setPosition(Short position) {
		this.position = position;
	}
	public Boolean getIs_default() {
		return is_default;
	}
	public void setIs_default(Boolean is_default) {
		this.is_default = is_default;
	}
}