package com.jabong.services.notification;

import java.util.List;

import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.notification.JabongBusMessage.ChangeType;
import com.jabong.services.response.BundleListResponse;

public class BundleNotify extends BaseNotify
{

    private BundleDAO bundleDao;

    public void setBundleDao(BundleDAO bundleDao)
    {
        this.bundleDao = bundleDao;
    }
    
    @Override
    public void prepareMessage(
        Type type, 
        JabongBusMessage message
    ) throws Exception {
        
        log.getExceptionLogger().error("preape message called");
        switch (type) {
            
            case ACTIVE_LIST:
                activeList(message);
            break;
            
            case CREATE:
            break;
            
            default:
                throw new IllegalArgumentException(
                    "Invalid Argument supplied");
        }
    }

    public void update(Integer id)
    {

    }

    public void create(Integer id)
    {

    }

    public void delete(Integer id)
    {

    }

    /**
     * Fetch Active list of bundles.
     * 
     * @param message
     * @throws Exception
     */
    public void activeList(JabongBusMessage message) 
            throws Exception
    {
        List<Bundle> bundles = bundleDao.fetchActiveList();
        BundleListResponse response = new BundleListResponse(bundles);
        int errorCode = response.getErrorcode();
        Object data = response.getData();
        if (errorCode > 1) {
            String errorMessage = (String) data;
            if (errorMessage.isEmpty()) {
                errorMessage = "Something went wrong with API";
            }
            throw new Exception(errorMessage);
        }
        message.setType("bundle");
        message.setData(data);
        message.setRouting_key("all");
        message.setType_of_change(ChangeType.create);
    }
}
