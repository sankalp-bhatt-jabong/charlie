package com.jabong.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jabong.models.dao.BundleDAO;
import com.jabong.services.util.ApplicationContextProvider;

public class JabongBus {


    public static final String BUS_URL = "http://bob.indfas-19445.qw/catalog-ext/webservice/update-price";
    public static final int MAX_TRIAL_LIMIT = 1;
    public static final int RESPONSE_SUCCESS_CODE = 200;
    public static final String stringData = "{ \r\n\"context\" :  { \r\n\t\"uid\" : \"33er33\",   \r\n    \"email\" : \"tutu@jabong.com\",   \r\n    \"old_price_consistency\" : 0,\r\n    \"partial_execution_allowed\" : 0,\r\n    \"chunk_size\":3,\r\n    \"special_from_date\":\"2014-12-22\", \r\n    \"special_to_date\":\"2015-10-10\" \r\n}, \r\n\"columns\":[\r\n\t\"id_catalog_simple\",\r\n    \"special_price\"\r\n    \r\n], \r\n\"data\":[ \r\n[1, 300.00],\r\n[2, 300.00],\r\n[148, 1000.00]\r\n] \r\n}";


	
	private void prePublish() {
		
	}
	
	private void postPublish() {
	        
	}

	public void publish() {
		this.prePublish();
		this.execute();
		//@todo add publish code with re-trial here.
	}
	
    private void execute()
    {
        int tryCount = 0;
        boolean retry = true;
        while (retry) {
            if (JabongBus.MAX_TRIAL_LIMIT >= tryCount) {
                break;
            }
            try {
                DefaultHttpClient httpclient = new DefaultHttpClient();
                HttpPost httpost = new HttpPost(JabongBus.BUS_URL);
                httpost.setEntity(new StringEntity(JabongBus.stringData));
                HttpResponse response = httpclient.execute(httpost);
                if (response.getStatusLine().getStatusCode() 
                        != JabongBus.RESPONSE_SUCCESS_CODE) {
                    throw new Exception("Invalid Response code");
                }
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    throw new Exception("Response is Empty");
                }
                String responseData = EntityUtils.toString(entity);
                retry = false;
                
            } catch (UnsupportedEncodingException e) {
                retry = true;
            } catch (ClientProtocolException e) {
                retry = true;
            } catch (IOException e) {
                retry = true;
            } catch (Exception e) {
                
            }
            
            finally{
                tryCount += 1;
            }

        }
    }

}


