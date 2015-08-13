package com.jabong.services.response;

import java.util.List;

import com.jabong.services.response.fields.bundle.BundleToSkuFields;

public class BundleToSkuResponse extends BaseResponse{
    public BundleToSkuResponse(Integer id, List<?> skus) {
        BundleToSkuFields fields = new BundleToSkuFields();
        fields.setId(id);
        fields.setSkuList(skus);
        this.setData(fields);
        this.setErrorcode(0);
        
    }
    
}