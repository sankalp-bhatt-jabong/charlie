package com.jabong.services.notification;

public class JabongBusMessage
{
    private String message_id;
    private final String publisher_name = "catalyst";
    private String routing_key;
    private long timestamp;
    private String type;
    private String type_of_change;
    private Object promotions;
    
    public JabongBusMessage() {
        getTimestamp();
        setMessageId();
    }
    
    public String getMessageId() {
        return message_id;
    }

    public void setMessageId() {
        //@todo: Implement message ID generation.
        String id = "asdd21331";
        this.message_id = id;
    }

    public String getRoutingKey() {
        return routing_key;
    }

    public void setRoutingKey(String routing_key) {
        this.routing_key = routing_key;
    }
    
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        long unixTime = System.currentTimeMillis() / 1000L;
        this.timestamp = unixTime;
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

    public String getPublisherName() {
        return publisher_name;
    }
 

}
