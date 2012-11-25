package com.habuma.ngws;

public class ApiError {

	private final String text;

	public ApiError(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
}
