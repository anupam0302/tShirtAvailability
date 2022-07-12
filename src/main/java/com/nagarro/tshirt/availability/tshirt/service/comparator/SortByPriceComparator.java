package com.nagarro.tshirt.availability.tshirt.service.comparator;

import java.util.Comparator;

import com.nagarro.tshirt.availability.model.TShirt;

public class SortByPriceComparator implements Comparator<TShirt> {

	@Override
	public int compare(TShirt tShirt1, TShirt tShirt2) {
		double priceOfTShirtFirst = tShirt1.getPrice();
		double priceOfTShirtSecond = tShirt2.getPrice();
		return Double.compare(priceOfTShirtFirst, priceOfTShirtSecond);
	}

}
