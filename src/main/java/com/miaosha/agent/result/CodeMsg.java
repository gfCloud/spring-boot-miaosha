package com.miaosha.agent.result;

public class CodeMsg {

	private int code;
	private String msg;

	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务异常");
	public static CodeMsg BIND_SERVER = new CodeMsg(500101, "服务异常");

	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500102, "密码不能为空！");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500103, "手机号不能为空！");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500104, "手机号格式错误！");
	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500105, "手机号不存在！");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500106, "密码错误！");
	
	
	
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public CodeMsg fillArgs(Object... args){
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code,message);
	}
	
	@Override
	public String toString(){
		return "CodeMsg [code="+code+";msg="+msg+"]";
	}
	

}
