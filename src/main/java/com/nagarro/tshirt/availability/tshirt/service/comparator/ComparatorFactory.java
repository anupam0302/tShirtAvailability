package com.nagarro.tshirt.availability.tshirt.service.comparator;

import java.util.Comparator;

import com.nagarro.tshirt.availability.model.TShirt;

public class ComparatorFactory {
	public static Comparator<TShirt> getSuitableComparator(int outputPreference) {
		if (outputPreference == 1) {
			return new SortByPriceComparator();
		} else if (outputPreference == 2) {
			return new SortByRatingComparator();
		} else {
			return new SortByPriceAndRatingComparator();
		}
	}
}
