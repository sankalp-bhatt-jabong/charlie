package com.jabong.services.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jabong.exception.DataNotFoundException;
import com.jabong.services.response.BaseResponse;

public class Sku2BundleMapResponse extends BaseResponse
{

    public Sku2BundleMapResponse(List<?> resultset)
    {
        Iterator<?> resultsetItr = resultset.iterator();
        Map<String, Object> response = new HashMap<String, Object>();
        while (resultsetItr.hasNext()) {
            Object[] objects = (Object[]) resultsetItr.next();
            ArrayList<Integer> bundleIds = new ArrayList<Integer>();
            bundleIds.add((Integer) objects[0]);
            response.put((String) objects[1], bundleIds);
        }
        try {
            if (response.isEmpty()) {
                throw new DataNotFoundException();
            }
            this.setData(response);
            this.setErrorCode(BaseResponse.NO_EXCEPTION);
        } catch (DataNotFoundException e) {
            this.setData(Collections.EMPTY_MAP);
            this.setErrorCode(BaseResponse.DATA_NOT_FOUND_EXCEPTION);
        } catch (Exception e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.OTHER_EXCEPTION);
        }
    }
}
