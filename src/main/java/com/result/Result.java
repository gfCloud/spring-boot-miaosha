package com.qixin.result;

public class Result<T> {

	private int code;
	private String msg;
	private T data;

	/*
	 * 封装成功返回结果
	 */

	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}

	/*
	 * 构造器
	 */
	private Result(T data) {
		this.code = 0;
		this.msg = "success";
		this.data = data;
	}

	/*
	 * 封装失败返回结果
	 * 
	 */
	public static <T> Result<T> error(CodeMsg cm) {
		return new Result<T>(cm);
	}

	private Result(CodeMsg cm) {
		if (cm == null) {
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

}
