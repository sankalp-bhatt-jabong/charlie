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
    protected void prepareMessage(
        Type type, 
        JabongBusMessage message,
        Integer id
    ) throws Exception {
        
        switch (type) {

            case ACTIVE_LIST:
                this.activeList(message);
            break;

            case CREATE:
                this.create(message, id);
            break;

            case UPDATE:
                this.update(message, id);
            break;
            
            case DELETE:
                this.delete(message, id);
            break;

            default:
                throw new IllegalArgumentException("Invalid Argument supplied");
        }
    }

    public void update(JabongBusMessage message, Integer id) 
            throws Exception
    {

    }

    public void create(JabongBusMessage message, Integer id) 
            throws Exception
    {
        
    }

    public void delete(JabongBusMessage message, Integer id) 
            throws Exception
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
                errorMessage = BundleNotify.CustomErrorMessage;
            }
            throw new Exception(errorMessage);
        }
        message.setType("bundle_list_active");
        message.setData(data);
        message.setRouting_key("all");
        message.setType_of_change(ChangeType.update);
    }
}
