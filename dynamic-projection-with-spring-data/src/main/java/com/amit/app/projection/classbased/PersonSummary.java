package com.amit.app.projection.classbased;

import com.amit.app.model.managed.Person;

public class PersonSummary {

	String firstname;
	String lastname;
	AddressSummary address;
	
	
	public PersonSummary(String firstname, String lastname, Person.Address address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = new AddressSummary(address.getCity());
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public AddressSummary getAddress() {
		return address;
	}


	public void setAddress(AddressSummary address) {
		this.address = address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonSummary other = (PersonSummary) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}


	static class AddressSummary {
		String city;

		public AddressSummary(String city) {
			super();
			this.city = city;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AddressSummary other = (AddressSummary) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			return true;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
	}
}
