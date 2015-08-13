package com.jabong.services.notification;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.jabong.services.util.SeaLogger;

public class JabongBus
{

    public static final String BUS_URL = "http://43.252.89.66:8087/work/pricing";
    public static final int    MAX_TRIAL_LIMIT       = 1;
    public static final int    RESPONSE_SUCCESS_CODE = 200;
    public static final int    RESPONSE_FAILED_CODE = 400;
    
    
    private static SeaLogger log = SeaLogger.getInstance();

    private void prePublish()
    {

    }

    private void postPublish()
    {

    }

    public void publish(JabongBusMessage message)
    {
        this.prePublish();
        this.execute(message);
        this.postPublish();
    }

    private Boolean execute(JabongBusMessage message)
    {
        int tryCount = 0;
        boolean retry = true;
        while (retry) {
            if (JabongBus.MAX_TRIAL_LIMIT <= tryCount) {
                break;
            }
            try {
                ObjectMapper mapper = new ObjectMapper();
                String messageJsonString = mapper.writeValueAsString(message);
                log.getExceptionLogger().error(messageJsonString);
                
                DefaultHttpClient httpclient = new DefaultHttpClient();
                HttpPost request = new HttpPost(JabongBus.BUS_URL);
                request.setEntity(
                    new StringEntity(messageJsonString)
                );
                request.setHeader(
                    HttpHeaders.CONTENT_TYPE, 
                    "application/json"
                );
                HttpResponse response = httpclient.execute(request);
                
                int responseCode = response.getStatusLine().getStatusCode();
                if ((responseCode != JabongBus.RESPONSE_SUCCESS_CODE) 
                    && (responseCode != JabongBus.RESPONSE_FAILED_CODE)) {
                    throw new Exception("["+responseCode+"] Invalid Response code");
                }
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    throw new Exception("Response is Empty");
                }
                String responseData = EntityUtils.toString(entity);
                
                JabongBusResponse mappedResponse = new JabongBusResponse();
                mappedResponse = mapper.readValue(
                    responseData, 
                    JabongBusResponse.class
                );
                if (mappedResponse.getSuccess() == true) {
                    log.getExceptionLogger().error("POSTED SUCCESFULLY");
                   return true;
                }
                retry = false;

            }  catch (Exception e) {
                log.getExceptionLogger().error(e);
                retry = true;
            }

            finally {
                tryCount += 1;
            }

        }
        return false;
    }

}
