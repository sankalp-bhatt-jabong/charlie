package com.jabong.services.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.jabong.services.response.BaseResponse;
import com.jabong.exception.DataNotFoundException;
import com.jabong.models.Bundle;
import com.jabong.services.response.fields.bundle.SummaryFields;

public class BundleListResponse extends BaseResponse
{

    public BundleListResponse(List<Bundle> bundles)
    {
        ListIterator<Bundle> bundleIterator = bundles.listIterator();
        ArrayList<SummaryFields> fields = new ArrayList<SummaryFields>();
        try {
            while (bundleIterator.hasNext()) {
                Bundle bundle = bundleIterator.next();
                SummaryFields sFields = new SummaryFields();
                sFields.setId(bundle.getId());
                sFields.setDisplay_name(bundle.getDisplayName());
                sFields.setName(bundle.getName());
                fields.add(sFields);
            }
            if (fields.isEmpty()) {
                throw new DataNotFoundException();
            }
            this.setData(fields);
            this.setErrorCode(BaseResponse.NO_EXCEPTION);
        } catch (DataNotFoundException e) {
            this.setData(Collections.EMPTY_LIST);
            this.setErrorCode(BaseResponse.DATA_NOT_FOUND_EXCEPTION);
        } catch (Exception e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.OTHER_EXCEPTION);
        }
    }

}
