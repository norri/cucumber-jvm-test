package com.eero.cucumber.app;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class InMemoryCarDAO implements CarDAO {
	
	private List<Car> cars = new ArrayList<Car>();

	@Override
	public void add(Car car) {
		cars.add(car);
	}

	@Override
	public Car findAvailable() {
		Optional<Car> result = Iterables.tryFind(cars, new CarAvailabilityPredicate());
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new NotAvailableException("No cars available");
		}
	}

	@Override
	public int getAvailableCars() {
		Iterable<Car> availableCars = Iterables.filter(cars, new CarAvailabilityPredicate()); 
		return Iterables.size(availableCars);
	}
	
	private class CarAvailabilityPredicate implements Predicate<Car> {
		@Override
		public boolean apply(Car car) {
			return car.isAvailable();
		}
	}
}
