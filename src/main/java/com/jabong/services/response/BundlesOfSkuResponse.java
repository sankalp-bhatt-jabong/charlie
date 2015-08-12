package com.jabong.services.response;

import java.util.List;

import com.jabong.exception.DataNotFoundException;
import com.jabong.services.response.BaseResponse;

public class BundlesOfSkuResponse extends BaseResponse
{

    public BundlesOfSkuResponse(List bundleIds)
    {
        try {
            if (bundleIds.isEmpty()) {
                throw new DataNotFoundException();
            }
            this.setData(bundleIds);
            this.setErrorCode(BaseResponse.No_EXCEPTION);
        } catch (DataNotFoundException e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.DATA_NOT_FOUND_EXCEPTION);
        } catch (Exception e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.OTHER_EXCEPTION);
        }
    }
}
