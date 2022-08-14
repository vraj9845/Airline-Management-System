package edu.neu.csye7374;

public class CanadaCurrency implements FlightPriceCurrency {
	public double conversionRate = 1.28;
	
	@Override
	public void showcurrency(double price) {
		System.out.println("Flight Price in Canadian Dollars:"+ price*conversionRate);
		
	}

}
