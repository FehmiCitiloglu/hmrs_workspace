package com.kodlamaIO.hmrs.core.utilities.results;

public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean succes, String message) {
		this(succes);
		this.message = message;
	}
	
	public boolean isSucces() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
