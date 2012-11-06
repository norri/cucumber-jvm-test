package com.eero.cucumber.app;

import static org.junit.Assert.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RentalSpecification {
	
	private CarDAO carDatabase;
	
	@Before
	public void init() {
		carDatabase = new InMemoryCarDAO();
	}
	
	@Given("^there are (\\d+) cars available for rental$")
	public void there_are_cars_available_for_rental(int availableCars) throws Throwable {
	    for (int i = 0; i < availableCars; i++) {
	    	Car car = new Car();
	    	carDatabase.add(car);
	    }
	}

	@When("^I rent one$")
	public void I_rent_one() throws Throwable {
	    Car car = carDatabase.findAvailable();
	    car.rent();
	}

	@Then("^there will only be (\\d+) cars available for rental$")
	public void there_will_only_be_cars_available_for_rental(int expectedAvailableCars) throws Throwable {
	    int availableCars = carDatabase.getAvailableCars();
	    assertEquals(availableCars, expectedAvailableCars);
	}
	
	@Given("^there are no cars available for rental$")
	public void there_are_no_cars_available_for_rental() throws Throwable {
	    // empty car database
	}

	@Then("^renting is not possible$")
	public void renting_is_not_possible() throws Throwable {
		try {
	    	I_rent_one();
	    } catch (NotAvailableException e) {
	    	assertEquals("No cars available", e.getMessage());
	    }
	}
}
