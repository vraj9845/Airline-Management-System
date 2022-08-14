package edu.neu.csye7374;

public class ChristmasDiscountStrategy implements DiscountStrategyAPI {
	public static final double Christmas_Discount_Percent=0.1;

	@Override
	public double CalculateDiscount (double price) {
		double final_price= price-(Christmas_Discount_Percent*price);
		return final_price;
	}
}
