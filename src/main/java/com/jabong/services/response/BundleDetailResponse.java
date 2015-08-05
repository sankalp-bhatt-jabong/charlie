package com.jabong.services.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.jabong.services.response.BaseResponse;
import com.jabong.models.Bundle;
import com.jabong.models.BundleSet;
import com.jabong.models.BundleSetOption;
import com.jabong.models.SkuBundleMessage;
import com.jabong.services.response.fields.bundle.DetailFields;
import com.jabong.services.response.fields.bundle.SetSummaryFields;

public class BundleDetailResponse extends BaseResponse {
	
	public Boolean displaySku = false;

	public BundleDetailResponse(Bundle bundle, Boolean displaySku) {

		this.displaySku = displaySku;
		DetailFields dFields = new DetailFields();
		dFields.setId(bundle.getId());
		dFields.setCsv_count(bundle.getCsvCount());
		dFields.setName(bundle.getName());
		dFields.setBundle_badge(bundle.getBundleBadge());
		dFields.setBundle_filter_text(bundle.getBundleFilterText());
		dFields.setDiscount_level(bundle.getDiscountLevel());
		dFields.setSkip_bundle_calculation(bundle.getSkipBundleCalculation());
		dFields.setFreebie_products(bundle.getFreebieProducts());
		dFields.setIs_checkout_disabled(bundle.getIsCheckoutDisabled());
		dFields.setIs_default_message_enabled(bundle
				.getIsDefaultMessageEnabled());
		dFields.setMessages(this.getBundleMessages(bundle));
		dFields.setAction_serialized(bundle.getActionSerialized());
		dFields.setSets(this.prepareSetList(bundle));
		dFields.setSkus_in_bundle(this.prepareSkuList(bundle));
		this.setStatus(true);
		this.setData(dFields);

	}

	private String getBundleMessages(Bundle bundle) {
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

	private ArrayList<String> prepareSkuList(Bundle bundle) {
		ArrayList<String> skuList = new ArrayList<String>();
		if (!this.displaySku) {
			return skuList;
		}
		Set<BundleSet> sets = bundle.getBundleSets();
		Iterator setIterator = sets.iterator();
		while (setIterator.hasNext()) {
			BundleSet bundleset = (BundleSet) setIterator.next();
			Set<BundleSetOption> setOptions = bundleset.getBundleSetOptions();
			Iterator optionItr = setOptions.iterator();
			while (optionItr.hasNext()) {
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