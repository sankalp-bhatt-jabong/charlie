package com.jabong.services.response;

<<<<<<< HEAD
import java.util.*;


public class BaseResponse {

   private Object data;
   private Boolean status;
   
   public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
}
=======
public class BaseResponse {

	private Boolean status;
	private Object data;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
>>>>>>> master
