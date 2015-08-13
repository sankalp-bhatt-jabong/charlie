package com.jabong.services.response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jabong.exception.DataNotFoundException;
import com.jabong.models.dao.VoucherDAO;
import com.jabong.services.ConditionsRuleSet;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.fields.voucher.PromotionVoucherFields;
import com.jabong.services.util.DateUtil;
import com.jabong.services.util.StringUtil;

public class VoucherListResponse extends BaseResponse
{

    public VoucherListResponse(List<Object> vouchers, VoucherDAO voucherDao)
    {

        HashMap<String, Object> promotionVoucherDetail = new HashMap<String, Object>();
        Iterator i = (Iterator) vouchers.iterator();
        try {
            while (i.hasNext()) {
                Object[] obj = (Object[]) i.next();
                int id = (Integer) obj[0];
                String crs = (String) obj[1];
                ConditionsRuleSet crsObj = new ConditionsRuleSet(crs);
                Map taggedItem = crsObj.getTaggedItem();
                if (!taggedItem.isEmpty()) {
                    PromotionVoucherFields fields = new PromotionVoucherFields();
                    if (taggedItem.containsKey("taggeditem")) {
                        String taggedItemValue = (String) taggedItem
                            .get("taggeditem");
                        if (taggedItemValue.equalsIgnoreCase("promotion")) {
                            Object[] salesRuleData = (Object[]) voucherDao.getSalesRuleData(id);
                            if (!(StringUtil.empty(salesRuleData))) {
                                fields.setId_sales_rule_set(id);
                                fields.setVoucher_code((String) salesRuleData[0]);
                                String fromDate = DateUtil.formatDateTime(salesRuleData[1].toString());
                                fields.setFrom_date(fromDate);
                                String toDate = DateUtil.formatDateTime(salesRuleData[2].toString());
                                fields.setTo_date(toDate);
                                int key1 = Integer.parseInt((String) taggedItem.get("tagvalue"));
                                String key = voucherDao.mapToTagValue(key1);
                                promotionVoucherDetail.put(key, fields);
                            }
                        }
                    }

                }

            }

            if (promotionVoucherDetail.isEmpty()) {
                throw new DataNotFoundException();
            }
            this.setData(promotionVoucherDetail);
            this.setErrorCode(BaseResponse.NO_EXCEPTION);

        } catch (DataNotFoundException e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.DATA_NOT_FOUND_EXCEPTION);
        } catch (Exception e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.OTHER_EXCEPTION);
        }
    }
}
