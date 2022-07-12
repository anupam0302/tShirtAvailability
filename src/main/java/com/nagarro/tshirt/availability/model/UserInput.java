package com.nagarro.tshirt.availability.model;

public class UserInput {
	private String color;
	private String gender;
	private String size;
	private int outputPreference;

	public UserInput(String color, String gender, String size, int outputPreference) {
		super();
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.outputPreference = outputPreference;
	}

	public String getColor() {
		return color;
	}

	public String getGender() {
		return gender;
	}

	public String getSize() {
		return size;
	}

	public int getOutputPreference() {
		return outputPreference;
	}

}
