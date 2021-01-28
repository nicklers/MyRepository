package com.wonders.codingchallenge.employee;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = -6029033848024994254L;
	private String street;
	private String city;
	private String zipcode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
