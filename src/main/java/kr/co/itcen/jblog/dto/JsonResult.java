package kr.co.itcen.jblog.dto;

public class JsonResult {
	private Boolean isRaisedException;
	private Object data;
	private String message;
	
	public static JsonResult success(Object data) {
		return new JsonResult(data);
	}
	
	public static JsonResult fail(String message) {
		return new JsonResult(message);
	}
	
	private JsonResult(Object data) {
		this.data = data;
		this.isRaisedException = false;
	}
	
	private JsonResult(String message) {
		this.message = message;
		this.isRaisedException = true;
	}
	public Boolean getIsRaisedException() {
		return isRaisedException;
	}
	public void setIsRaisedException(Boolean isRaisedException) {
		this.isRaisedException = isRaisedException;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
		
}
