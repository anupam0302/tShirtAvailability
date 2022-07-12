package com.nagarro.tshirt.availability.output;

import java.util.ArrayList;

import com.nagarro.tshirt.availability.model.TShirt;

public class OutputHandler {

	public void printOutput(ArrayList<TShirt> tShirts) {
		tShirts.forEach(tshirt -> System.out.println(tshirt.toString()));
	}

}
