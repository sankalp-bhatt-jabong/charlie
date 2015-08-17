package com.jabong.services.response;

import java.util.List;
import com.jabong.exception.DataNotFoundException;
import com.jabong.services.response.fields.bundle.BundleToSkuFields;

public class BundleToSkuResponse extends BaseResponse
{
    public BundleToSkuResponse(Integer id, List<?> skus)
    {
        BundleToSkuFields fields = new BundleToSkuFields();
        try {
            fields.setId(id);
            fields.setSku_list(skus);
            if (skus.isEmpty()) {
                throw new DataNotFoundException();
            }
            this.setData(fields);
            this.setErrorcode(BaseResponse.NO_EXCEPTION);
        } catch (DataNotFoundException e) {
            this.setData(fields);
            this.setErrorcode(BaseResponse.DATA_NOT_FOUND_EXCEPTION);
        } catch (Exception e) {
            this.setData(e.getMessage());
            this.setErrorcode(BaseResponse.OTHER_EXCEPTION);
        }

    }

}