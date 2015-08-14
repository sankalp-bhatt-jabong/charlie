package com.jabong.services.notification;

public class JabongBusMessage
{
    private String id;
    private final String publisher_name = "catalyst";
    private String routing_key;
    private long timestamp;
    private String type;
    private ChangeType type_of_change;
    private Object data;
    
    public enum ChangeType {
        create, update, delete
    }
    
    public JabongBusMessage() {
        setTimestamp();
        setid();
    }
    
    public String getid() {
        return id;
    }

    public void setid() {
        //@todo: Implement message ID generation.
        String id = "asdd21331";
        this.id = id;
    }

    public String getRouting_key() {
        return routing_key;
    }

    public void setRouting_key(String routing_key) {
        this.routing_key = routing_key;
    }
    
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        long unixTime = System.currentTimeMillis();
        this.timestamp = unixTime;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChangeType getType_of_change() {
        return type_of_change;
    }

    public void setType_of_change(ChangeType type_of_change) {
        this.type_of_change = type_of_change;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPublisher_name() {
        return publisher_name;
    }
 

}
