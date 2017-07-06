package com.dotest.we.models;

public class Response {

	
	public Object data;
	public Err error;
	
	
	
	public Response(Object data, Err error) {
		super();
		this.data = data;
		this.error = error;
	}
	
	public static class Err{
		public int code;
		public String msg;
		public Err(int code, String msg) {
			super();
			this.code = code;
			this.msg = msg;
		}
		
		
	}
	
	public static class SimpleMsg{
		public int code;
		public String msg;
		public SimpleMsg(int code, String msg) {
			super();
			this.code = code;
			this.msg = msg;
		}
		
		
	}
}

