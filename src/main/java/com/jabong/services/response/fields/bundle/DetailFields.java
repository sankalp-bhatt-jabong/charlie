package com.jabong.services.response.fields.bundle;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class DetailFields {

	private int id;
	private Integer csv_count;
	private String name;
	private String bundle_badge;
	private String bundle_filter_text;
	private String discount_level;
	private Integer skip_bundle_calculation;
	private Integer is_checkout_disabled;
	private List<?> freebie_products;
	private Integer is_default_message_enabled;
	private Map messages;
	private ActionSerializedFields action_serialized;
	private List<SetSummaryFields> sets;
	private List<String> skus_in_bundle;

	public List<?> getFreebie_products() {
		return freebie_products;
	}

	public void setFreebie_products(String freebie_products) {
		List<?> data = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = (List<?>) mapper.readValue(freebie_products, List.class);
		} catch (Exception e) {
			// do nothing
		}
		this.freebie_products = data;
	}

	public Map getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		Map data = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = (Map) mapper.readValue(messages, Map.class);
		} catch (Exception e) {
			// do nothing
		}
		this.messages = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCsv_count() {
		return csv_count;
	}

	public void setCsv_count(Integer csv_count) {
		this.csv_count = csv_count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBundle_badge() {
		return bundle_badge;
	}

	public void setBundle_badge(String bundle_badge) {
		this.bundle_badge = bundle_badge;
	}

	public String getBundle_filter_text() {
		return bundle_filter_text;
	}

	public void setBundle_filter_text(String bundle_filter_text) {
		this.bundle_filter_text = bundle_filter_text;
	}

	public String getDiscount_level() {
		return discount_level;
	}

	public void setDiscount_level(String discount_level) {
		this.discount_level = discount_level;
	}

	public Integer getSkip_bundle_calculation() {
		return skip_bundle_calculation;
	}

	public void setSkip_bundle_calculation(Integer skip_bundle_calculation) {
		this.skip_bundle_calculation = skip_bundle_calculation;
	}

	public Integer getIs_checkout_disabled() {
		return is_checkout_disabled;
	}

	public void setIs_checkout_disabled(Integer is_checkout_disabled) {
		this.is_checkout_disabled = is_checkout_disabled;
	}

	public Integer getIs_default_message_enabled() {
		return is_default_message_enabled;
	}

	public void setIs_default_message_enabled(Integer is_default_message_enabled) {
		this.is_default_message_enabled = is_default_message_enabled;
	}

	public ActionSerializedFields getAction_serialized() {
		return action_serialized;
	}

	public void setAction_serialized(String action_serialized) {
		ActionSerializedFields data = new ActionSerializedFields();
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(action_serialized,
					ActionSerializedFields.class);
		} catch (Exception e) {
			// do nothing
		}
		this.action_serialized = data;
	}

	public List<SetSummaryFields> getSets() {
		return sets;
	}

	public void setSets(List<SetSummaryFields> sets) {
		this.sets = sets;
	}

	public List<String> getSkus_in_bundle() {
		return skus_in_bundle;
	}

	public void setSkus_in_bundle(List<String> skus_in_bundle) {
		this.skus_in_bundle = skus_in_bundle;
	}

}
