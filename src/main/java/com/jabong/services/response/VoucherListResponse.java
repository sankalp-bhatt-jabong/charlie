package com.jabong.services.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.jabong.services.response.BaseResponse;

public class VoucherListResponse extends BaseResponse {

	public VoucherListResponse(List<?> resultset) {
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
