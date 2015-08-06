package com.jabong.services.response;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import com.jabong.services.response.BaseResponse;
import com.jabong.models.Bundle;
import com.jabong.services.response.fields.bundle.SummaryFields;

public class BundleListResponse extends BaseResponse {

	public BundleListResponse(List<Bundle> bundles) {
		ListIterator<Bundle> bundleIterator = bundles.listIterator();
		ArrayList<SummaryFields> fields = new ArrayList<SummaryFields>();
		while (bundleIterator.hasNext()) {
			Bundle bundle = bundleIterator.next();
			SummaryFields sFields = new SummaryFields();
			sFields.setId(bundle.getId());
			sFields.setDisplay_name(bundle.getDisplayName());
			fields.add(sFields);
		}
		this.setData(fields);
		this.setStatus(true);
	}

}
