package com.eero.cucumber.app;

public class Car {

	private boolean isAvailable = true;
	
	public Car() {
	}
	
	public void rent() {
		isAvailable = false;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
}
