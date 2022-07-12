package com.nagarro.tshirt.availability.tshirt.service;

import java.util.ArrayList;
import java.util.Collections;

import com.nagarro.tshirt.availability.model.TShirt;
import com.nagarro.tshirt.availability.tshirt.service.comparator.ComparatorFactory;

public class DataSorter {
	public ArrayList<TShirt> sortData(int outputPreference, ArrayList<TShirt> tShirts) {
		Collections.sort(tShirts, ComparatorFactory.getSuitableComparator(outputPreference));
		return tShirts;
	}
}
