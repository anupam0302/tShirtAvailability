package com.nagarro.tshirt.availability.tshirt.service.comparator;

import java.util.Comparator;

import com.nagarro.tshirt.availability.model.TShirt;

public class SortByRatingComparator implements Comparator<TShirt> {

	@Override
	public int compare(TShirt tShirt1, TShirt tShirt2) {
		double ratingOfTShirtFirst = tShirt1.getRating();
		double ratingOfTShirtSecond = tShirt2.getRating();
		return Double.compare(ratingOfTShirtFirst, ratingOfTShirtSecond);
	}

}
