package com.nagarro.tshirt.availability.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tshirt")
public class TShirt {
	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private double price;
	private double rating;
	private String availability;

	public TShirt() {
		this.id = "NA";
		this.name = "NA";
		this.color = "NA";
		this.gender = "NA";
		this.size = "NA";
		this.price = 0;
		this.rating = 0;
		this.availability = "NA";
	}

	public TShirt(String id, String name, String color, String gender, String size, double price, double rating,
			String availability) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public String getAvailability() {
		return availability;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + color + " " + gender + " " + size + " " + price + " " + rating + " "
				+ availability;
	}

}
