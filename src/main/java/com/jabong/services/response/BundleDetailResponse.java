package com.jabong.services.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.jabong.services.response.BaseResponse;
import com.jabong.models.Bundle;
import com.jabong.models.BundleSet;
import com.jabong.models.BundleSetOption;
import com.jabong.services.response.fields.bundle.DetailFields;
import com.jabong.services.response.fields.bundle.SetSummaryFields;
import com.jabong.services.response.fields.bundle.SummaryFields;

public class BundleDetailResponse extends BaseResponse{
	

	public BundleDetailResponse(Bundle bundle) {
		
		DetailFields dFields = new DetailFields();
		dFields.setId(bundle.getId());
		dFields.setCsv_count(bundle.getCsvCount());
		dFields.setName(bundle.getName());
		dFields.setBundle_badge(bundle.getBundleBadge());
		dFields.setBundle_filter_text(bundle.getBundleFilterText());
		dFields.setDiscount_level(bundle.getDiscountLevel());
		dFields.setSkip_bundle_calculation(bundle.getSkipBundleCalculation());
		dFields.setIs_checkout_disabled(bundle.getIsCheckoutDisabled());
		dFields.setIs_default_message_enabled(bundle.getIsDefaultMessageEnabled());
		dFields.setAction_serialized(bundle.getActionSerialized());
		dFields.setSets(this.prepareSetList(bundle));
		dFields.setSkus_in_bundle(this.prepareSkuList(bundle));
		this.setStatus(true);
		this.setData(dFields);
		
	}
	
	
	private ArrayList<String> prepareSkuList(Bundle bundle) {
		Set<BundleSet> sets = bundle.getBundleSets();
		Iterator setIterator = sets.iterator();
		ArrayList<String> skuList = new ArrayList<String>();
		while(setIterator.hasNext()) {
			BundleSet bundleset = (BundleSet) setIterator.next();
			Set<BundleSetOption> setOptions = bundleset.getBundleSetOptions();
			Iterator optionItr = setOptions.iterator();
			while(optionItr.hasNext()) {
				BundleSetOption skuD = (BundleSetOption) optionItr.next();
				skuList.add(skuD.getSku());
			}
		}
		return skuList;
	}
	
	private ArrayList<SetSummaryFields> prepareSetList(Bundle bundle) {
		Set<BundleSet> sets = bundle.getBundleSets();
		Iterator setIterator = sets.iterator();
		ArrayList<SetSummaryFields> setList = new ArrayList<SetSummaryFields>();
		while(setIterator.hasNext()) {
			BundleSet bundleset = (BundleSet) setIterator.next();
			SetSummaryFields setSummary = new SetSummaryFields();
			setSummary.setId_sku_bundle_sets(bundleset.getId());
			setSummary.setDiscount_applicable_on(bundleset.getDiscountApplicableOn());
			setSummary.setOperator(bundleset.getOperator());
			setSummary.setQuantity(bundleset.getQuantity());
			setList.add(setSummary);
		}
		return setList;
	}
	
}
