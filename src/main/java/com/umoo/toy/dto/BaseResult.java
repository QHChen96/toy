package com.umoo.toy.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BaseResult<T> implements Serializable{
	private static final long serialVersionUID = -149660459129353121L;
	
	private boolean success;
	
	@JsonInclude(Include.NON_NULL)
	private T data;
	
	@JsonInclude(Include.NON_NULL)
	private String msg;
	
	public BaseResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public BaseResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BaseResult [success=" + success + ", data=" + data + ", msg="
				+ msg + "]";
	}
}
