package com.jabong.services.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import com.jabong.services.response.BaseResponse;
import com.jabong.exception.DataNotFoundException;
import com.jabong.models.Bundle;
import com.jabong.models.BundleSet;
import com.jabong.models.BundleSetOption;
import com.jabong.models.SkuBundleMessage;
import com.jabong.services.response.fields.bundle.DetailFields;
import com.jabong.services.response.fields.bundle.SetSummaryFields;

public class BundleDetailResponse extends BaseResponse
{

    public BundleDetailResponse(Bundle bundle)
    {
        try {
            if (bundle == null) {
                throw new DataNotFoundException();
            }
            DetailFields dFields = new DetailFields();
            dFields.setId(bundle.getId());
            dFields.setCsv_count(bundle.getCsvCount());
            dFields.setName(bundle.getName());
            dFields.setBundle_badge(bundle.getBundleBadge());
            dFields.setBundle_filter_text(bundle.getBundleFilterText());
            dFields.setDiscount_level(bundle.getDiscountLevel());
            dFields.setSkip_bundle_calculation(bundle
                .getSkipBundleCalculation());
            dFields.setFreebie_products(bundle.getFreebieProducts());
            dFields.setIs_checkout_disabled(bundle.getIsCheckoutDisabled());
            dFields.setIs_default_message_enabled(bundle
                .getIsDefaultMessageEnabled());
            dFields.setMessages(this.getBundleMessages(bundle));
            dFields.setAction_serialized(bundle.getActionSerialized());
            dFields.setSets(this.prepareSetList(bundle));
            this.setErrorCode(BaseResponse.NO_EXCEPTION);
            this.setData(dFields);

        } catch (DataNotFoundException e) {
            this.setData(Collections.EMPTY_MAP);
            this.setErrorCode(BaseResponse.DATA_NOT_FOUND_EXCEPTION);

        } catch (Exception e) {
            this.setData(e.getMessage());
            this.setErrorCode(BaseResponse.OTHER_EXCEPTION);
        }
    }

    private String getBundleMessages(Bundle bundle)
    {
        String messages = "";
        int defaultMessageEnabled = bundle.getIsDefaultMessageEnabled();
        if (defaultMessageEnabled == 1) {
            messages = bundle.getDefaultMessages();
        } else {
            Set bundleMessages = bundle.getBundleMessages();
            if (bundleMessages.iterator().hasNext()) {
                SkuBundleMessage skumessage = (SkuBundleMessage) bundleMessages
                    .iterator().next();
                messages = skumessage.getMessages();
            }

        }
        return messages;
    }


    private ArrayList<SetSummaryFields> prepareSetList(Bundle bundle)
    {
        Set<BundleSet> sets = bundle.getBundleSets();
        Iterator setIterator = sets.iterator();
        ArrayList<SetSummaryFields> setList = new ArrayList<SetSummaryFields>();
        while (setIterator.hasNext()) {
            BundleSet bundleset = (BundleSet) setIterator.next();
            SetSummaryFields setSummary = new SetSummaryFields();
            setSummary.setId_sku_bundle_sets(bundleset.getId());
            setSummary.setDiscount_applicable_on(bundleset
                .getDiscountApplicableOn());
            setSummary.setOperator(bundleset.getOperator());
            setSummary.setQuantity(bundleset.getQuantity());
            setList.add(setSummary);
        }
        return setList;
    }

}
