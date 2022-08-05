package com.example.demo.util;
/**
 * 返回状态
 * @author lhb 2014/10/27
 * @version 1.0
 */
public class State {
	private String code;
	
	private String msg;
	
	private String debugmsg;
	
	private String editDate;
	
	public State(){
		
	}
	
	public State(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDebugmsg() {
		return debugmsg;
	}

	public void setDebugmsg(String debugmsg) {
		this.debugmsg = debugmsg;
	}
	
	public void clear(){
		code = "";
		msg = "";
		debugmsg = "";
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
}
