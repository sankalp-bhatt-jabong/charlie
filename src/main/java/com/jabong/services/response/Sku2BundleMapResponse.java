package com.jabong.services.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.jabong.services.response.BaseResponse;
import com.jabong.models.Bundle;
import com.jabong.services.response.fields.bundle.SummaryFields;

public class Sku2BundleMapResponse extends BaseResponse{
	

	public Sku2BundleMapResponse(List<?> resultset) {
		Iterator<?> resultsetItr = resultset.iterator();
		Map<String, Object> response = new HashMap<String, Object>();
		while (resultsetItr.hasNext()) {
			Object[] objects = (Object[]) resultsetItr.next();
			ArrayList<Integer> bundleIds = new ArrayList<Integer>();
			bundleIds.add((Integer) objects[0]);
			response.put((String) objects[1], bundleIds);
		}
		this.setData(response);
		this.setStatus(true);
	}
}