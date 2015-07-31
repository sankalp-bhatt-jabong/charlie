package com.jabong.services.response;

import java.util.*;
import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;

public class BundleListResponse extends BaseResponse{

	public ArrayList<HashMap> data;
	
	public BundleListResponse(List<Bundle> bundles) {
		ListIterator<Bundle> bundleIterator = bundles.listIterator();
		while(bundleIterator.hasNext()) {
			Bundle bundle = bundleIterator.next();
			this.mapResponse(bundle);
		}
	}
	
	public void mapResponse(Bundle bundle) {
		HashMap test = new HashMap();
		
		test.put("id", bundle.getId());
		test.put("display_name", bundle.getDisplayName());
		data.add(test);
		
	}
}
