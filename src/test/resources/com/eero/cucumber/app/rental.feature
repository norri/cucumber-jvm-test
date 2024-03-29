Feature: Rental cars should be possible to gain revenue to the rental company.

	As an owner of a car rental company
	I want to make cars available for renting
	So I can make money
	
	Scenario: Find and rent a car
		Given there are 18 cars available for rental
		When I rent one
		Then there will only be 17 cars available for rental
		
	Scenario: No available cars when renting
		Given there are no cars available for rental
		Then renting is not possible
		