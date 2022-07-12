package com.nagarro.tshirt.availability.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.nagarro.tshirt.availability.exceptions.InvalidInputException;
import com.nagarro.tshirt.availability.model.UserInput;

public class InputReader {

	// inputVariables have those variables which are used to filter data from CSV
	// file
	public UserInput inputVariables() throws InvalidInputException {
		String color;
		String gender;
		String size;
		int outputPreference = 0;

		Scanner scanner = ScannerFactory.getScanner();

		System.out.println("Enter the color of the TShirt : ");
		color = scanner.next().toLowerCase().trim();
		System.out.println("Enter the gender recommendation (m/f)");
		gender = scanner.next().toLowerCase().trim();
		if (!("m".equals(gender) || "f".equals(gender))) {
			throw new InvalidInputException("Gender should be either m or f. Please try again.");
		}
		System.out.println("Enter the size of t-shirt (s/m/l/xl/xxl)");
		size = scanner.next().toLowerCase().trim();
		if (!("s".equals(size) || "m".equals(size) || "l".equals(size) || "xl".equals(size) || "xxl".equals(size))) {
			throw new InvalidInputException(
					"The entered size for the t-shirt is invalid. Size should be from s, m, l, xl and xxl.");
		}
		System.out.println("Enter : ");
		System.out.println("1 for sort by price");
		System.out.println("2 for sort by rating");
		System.out.println("3 for sort by both price and rating");
		try {
			outputPreference = scanner.nextInt();
			if (outputPreference < 1 || outputPreference > 3) {
				throw new InvalidInputException(
						"The number should be from 1 to 3 as per requirement. Please try again.");
			}

		} catch (InputMismatchException e) {
			System.out.println("Entered value for sorting operation must be an Integer from 1-3. Please try again.");
			inputVariables();
		}
		return new UserInput(color, gender, size, outputPreference);

	}

}
