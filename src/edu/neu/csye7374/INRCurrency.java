package edu.neu.csye7374;

public class INRCurrency implements FlightPriceCurrency {
	public double conversionRate =79.2;
	
	@Override
	public void showcurrency(double price) {
		System.out.println("Flight Price in INR:"+ price*conversionRate);
		
	}

	

}
