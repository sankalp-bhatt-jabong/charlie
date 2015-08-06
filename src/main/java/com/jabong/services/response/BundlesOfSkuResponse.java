package com.jabong.services.response;

import java.util.List;

import com.jabong.services.response.BaseResponse;

public class BundlesOfSkuResponse extends BaseResponse {

	public BundlesOfSkuResponse(List bundleIds) {
		this.setData(bundleIds);
		this.setStatus(true);
	}

}
