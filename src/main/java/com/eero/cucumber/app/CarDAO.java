package com.eero.cucumber.app;

public interface CarDAO {
	
	public void add(Car car);
	
	public Car findAvailable();

	public int getAvailableCars();

}
