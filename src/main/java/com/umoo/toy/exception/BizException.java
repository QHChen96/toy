package com.umoo.toy.exception;

/**
 * 
 * @author umoo
 * 业务逻辑异常
 */
public class BizException extends RuntimeException{
	private static final long serialVersionUID = -6521515280580419813L;
	public BizException(String message) {
		super(message);
	}
	public BizException(String message, Throwable cause) {
		super(message, cause);
	}
}
