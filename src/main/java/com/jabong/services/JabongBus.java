package com.jabong.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jabong.models.dao.BundleDAO;
import com.jabong.services.util.ApplicationContextProvider;

public class JabongBus {

	final static Logger logger = Logger.getLogger(JabongBus.class);

	private String message_id;
	private final String publisher_name = "promotions";
	private String routing_key;
	private String timestamp;
	private String type;
	private String type_of_change;
	private Object promotions;

	public String getMessageId() {
		return message_id;
	}

	public void setMessageId(String message_id) {
		this.message_id = message_id;
	}

	public String getRoutingKey() {
		return routing_key;
	}

	public void setRoutingKey(String routing_key) {
		this.routing_key = routing_key;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeOfChange() {
		return type_of_change;
	}

	public void setTypeOfChange(String type_of_change) {
		this.type_of_change = type_of_change;
	}

	public Object getData() {
		return promotions;
	}

	public void setData(Object promotions) {
		this.promotions = promotions;
	}

	public String getPublisher_name() {
		return publisher_name;
	}
	
	private void prePublish() {
		
	}

	public void publish() {
		this.prePublish();
		//@todo add publish code with re-trial here.
	}

}
