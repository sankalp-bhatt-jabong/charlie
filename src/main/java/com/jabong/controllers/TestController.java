package com.jabong.controllers;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.notification.BundleNotify;
import com.jabong.services.notification.JabongBus;
import com.jabong.services.notification.JabongBusMessage;
import com.jabong.services.notification.BaseNotify.Type;
import com.jabong.services.notification.JabongBusMessage.ChangeType;
import com.jabong.services.notification.JabongBusResponse;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.BundleDetailResponse;
import com.jabong.services.response.BundleListResponse;
import com.jabong.services.response.BundlesOfSkuResponse;
import com.jabong.services.response.Sku2BundleMapResponse;
import com.jabong.services.util.SeaLogger;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/test")
public class TestController extends AppController
{
    @Autowired
    private BundleNotify bundleNotify;
    
    private static SeaLogger log = SeaLogger.getInstance();
    
    @RequestMapping("/test2")
    public @ResponseBody Object test2() throws Exception
    {
        log.getExceptionLogger().error("in");
        bundleNotify.sendNotification(Type.ACTIVE_LIST);
        return "posted";
    }

    @RequestMapping("/test")
    public @ResponseBody Object test() throws Exception
    {
        String url = "http://43.252.89.66:8087/work/pricing";

        JabongBusMessage message = new JabongBusMessage();
        message.setRouting_key("all");
        message.setType_of_change(ChangeType.create);
        message.setType("bundle");
        
        ObjectMapper mapper = new ObjectMapper();
        String messageJsonString = mapper.writeValueAsString(message);

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(url);
        httpost.setEntity(new StringEntity(messageJsonString));
        httpost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpResponse response = httpclient.execute(httpost);
        int responseCode = response.getStatusLine().getStatusCode();
        //if (responseCode != JabongBus.RESPONSE_SUCCESS_CODE) {
          //  throw new Exception("["+responseCode+"]Invalid Response code");
       // }
        HttpEntity entity = response.getEntity();
        
        String responseData = EntityUtils.toString(entity);
        if (entity == null) {
            // throw an exception
        }
        
        JabongBusResponse mappedResponse = new JabongBusResponse();
        mappedResponse = mapper.readValue(responseData, JabongBusResponse.class);
        if (mappedResponse.getSuccess() == true) {
            return "posted";
        }
        
        
        // @todo check if response is success
        return mappedResponse;
        
        //return message;
    }
}
