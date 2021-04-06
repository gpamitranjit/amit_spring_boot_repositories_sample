package com.amit.app.projection.interfacebased;

import org.springframework.beans.factory.annotation.Value;

public interface NameOnly {

	String getFirstname();
	String getLastname();
	
	@Value("#{target.firstname + ' ' + target.lastname}")
	String getFullname();
	
	default String getNameDetails() {
		return getFirstname().concat(" ").concat(getLastname());
	}
}
