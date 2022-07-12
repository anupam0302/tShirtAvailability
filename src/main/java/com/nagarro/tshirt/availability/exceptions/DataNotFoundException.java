package com.nagarro.tshirt.availability.exceptions;

public class DataNotFoundException extends Exception {
	public DataNotFoundException() {
		super("Data not found as per filters and requirement. Please try again for other options.");
	}
}
