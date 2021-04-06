package com.amit.app.projection.interfacebased;

public interface PersonSummary {

	String getFirstname();
	String getLastname();
	AddressSummary getAddress();
	
	interface AddressSummary {
		String getCity();
	}
}
