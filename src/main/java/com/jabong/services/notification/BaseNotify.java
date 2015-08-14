package com.jabong.services.notification;

import org.springframework.scheduling.annotation.Async;

import com.jabong.services.util.SeaLogger;

public class BaseNotify
{
    public static final int MAX_TRIAL_LIMIT = 2;
    
    public static String CustomErrorMessage = "Error: Cannot prepare data to publish";
    
    public static SeaLogger log = SeaLogger.getInstance();

    public enum Type {
        CREATE, 
        UPDATE, 
        DELETE,
        LIST,
        ACTIVE_LIST
    }

    @Async
    public void sendNotification(Type type)
    {
        sendNotification(type, 0);
    }

    @Async
    public void sendNotification(Type type, int id)
    {
        try {
        Thread.sleep(100000);
        } catch(Exception e) {
            
        }
        JabongBusMessage message = new JabongBusMessage();
        int tryCount = 0;
        boolean retry = true;
        while (retry) {
            if (BaseNotify.MAX_TRIAL_LIMIT <= tryCount) {
                break;
            }
            try {
                this.prepareMessage(type, message, id);
                retry = false;
                JabongBus jabongBus = new JabongBus();
                jabongBus.publish(message);
            } catch (IllegalArgumentException e) {
                retry = false;
            } catch (Exception e) {
                retry = true;
            } finally {
                tryCount += 1;
            }
        }

    }

    /**
     * This function needs to be overridden in child Class. 
     */
    protected void prepareMessage(Type type, JabongBusMessage message, Integer id) 
            throws Exception
    {
    }
}
