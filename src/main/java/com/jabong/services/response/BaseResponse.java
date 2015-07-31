package com.jabong.services.response;

import java.util.*;


abstract public class BaseResponse {

	public Boolean status;

	public void setSuccessStatus() {
		this.status = true;
	}
	
	public void setFailureStatus() {
		this.status = false;
	}
}
