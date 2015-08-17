package com.jabong.services.notification;

import java.util.List;


import com.jabong.models.Bundle;
import com.jabong.models.Voucher;
import com.jabong.models.dao.BundleDAO;
import com.jabong.models.dao.VoucherDAO;
import com.jabong.services.notification.JabongBusMessage.ChangeType;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.BundleListResponse;
import com.jabong.services.response.VoucherPromotionsResponse;
import com.jabong.services.response.VoucherResponse;

public class VoucherNotify extends BaseNotify
{

    private VoucherDAO voucherDao;
    
    public void setVoucherDao(VoucherDAO voucherDao)
    {
        this.voucherDao = voucherDao;
    }
    
    @Override
    protected void prepareMessage(
        Type type, 
        JabongBusMessage message,
        Integer id
    ) throws Exception {
        
        switch (type) {

            case LIST:
                this.list(message);
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
    
    /**
     * 
     * @param message
     * @throws Exception
     */
    public void list(JabongBusMessage message) 
            throws Exception
    {
        List<Object> vouchers = voucherDao.getActiveList();
        BaseResponse response = new VoucherPromotionsResponse(
            vouchers, this.voucherDao
        );
        int errorCode = response.getErrorcode();
        Object data = response.getData();
        if (errorCode > 1) {
            String errorMessage = (String) data;
            if (errorMessage.isEmpty()) {
                errorMessage = VoucherNotify.CustomErrorMessage;
            }
            throw new Exception(errorMessage);
        }
        message.setType("voucher_promotions");
        message.setType_of_change(ChangeType.update);
        message.setData(data);
        message.setRouting_key("all");
    }
    
    

    /**
     * 
     * @param message
     * @param id
     * @throws Exception
     */
    public void update(JabongBusMessage message, Integer id) 
            throws Exception
    {
        Voucher voucher = voucherDao.getDetailById(id);
        BaseResponse response = new VoucherResponse(voucher);
        int errorCode = response.getErrorcode();
        Object data = response.getData();
        if (errorCode > 1) {
            String errorMessage = (String) data;
            if (errorMessage.isEmpty()) {
                errorMessage = VoucherNotify.CustomErrorMessage;
            }
            throw new Exception(errorMessage);
        }
        message.setType("voucher_detail");
        message.setType_of_change(ChangeType.update);
        message.setData(data);
        message.setRouting_key("all");
    }

    /**
     * 
     * @param message
     * @param id
     * @throws Exception
     */
    public void create(JabongBusMessage message, Integer id) 
            throws Exception
    {
        Voucher voucher = voucherDao.getDetailById(id);
        BaseResponse response = new VoucherResponse(voucher);
        int errorCode = response.getErrorcode();
        Object data = response.getData();
        if (errorCode > 1) {
            String errorMessage = (String) data;
            if (errorMessage.isEmpty()) {
                errorMessage = VoucherNotify.CustomErrorMessage;
            }
            throw new Exception(errorMessage);
        }
        message.setType("voucher_detail");
        message.setType_of_change(ChangeType.create);
        message.setData(data);
        message.setRouting_key("all");
    }

    public void delete(JabongBusMessage message, Integer id) 
            throws Exception
    {

    }

}
