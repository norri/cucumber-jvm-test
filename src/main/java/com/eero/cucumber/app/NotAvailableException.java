package com.eero.cucumber.app;

public class NotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotAvailableException(String msg) {
		super(msg);
	}
}
