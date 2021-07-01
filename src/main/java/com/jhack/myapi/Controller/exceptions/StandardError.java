package com.jhack.myapi.Controller.exceptions;

public class StandardError {

	private Integer status;
	private Long timesTamp;
	private String message;

	public StandardError() {
		super();

	}

	public StandardError(Integer status, Long timesTamp, String message) {
		super();
		this.status = status;
		this.timesTamp = timesTamp;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
