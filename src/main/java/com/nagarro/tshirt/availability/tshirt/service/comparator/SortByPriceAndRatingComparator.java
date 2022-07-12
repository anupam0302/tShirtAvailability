package com.nagarro.tshirt.availability.tshirt.service.comparator;

import java.util.Comparator;

import com.nagarro.tshirt.availability.model.TShirt;

public class SortByPriceAndRatingComparator implements Comparator<TShirt> {

	@Override
	public int compare(TShirt tShirt1, TShirt tShirt2) {

		double priceOfTShirtFirst = tShirt1.getPrice();
		double priceOfTShirtSecond = tShirt2.getPrice();
		int comparedResult = Double.compare(priceOfTShirtFirst, priceOfTShirtSecond);
		if (comparedResult != 0) {
			return comparedResult;
		}
		double ratingOfTShirtFirst = tShirt1.getRating();
		double ratingOfTShirtSecond = tShirt2.getRating();
		return Double.compare(ratingOfTShirtFirst, ratingOfTShirtSecond);
	}

}
