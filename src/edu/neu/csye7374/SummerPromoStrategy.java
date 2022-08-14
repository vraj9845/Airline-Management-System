package edu.neu.csye7374;

public class SummerPromoStrategy implements DiscountStrategyAPI {
	public static final double Summer_Promo_Reduce_Price=150.00;

	@Override
	public double CalculateDiscount (double price) {
		double final_price= price-Summer_Promo_Reduce_Price;
		return final_price;
	}
}