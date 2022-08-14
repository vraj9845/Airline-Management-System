package edu.neu.csye7374;

public class CurrencyAdapter implements FlightPriceCurrency{
	
	Currency c ;
	
	public CurrencyAdapter(Currency c) {
		this.c = c;
	}
	
	@Override
	public void showcurrency(double price) {
		c.showpriceCurrency(price);
		}
	
	public static void Adapterdemo() {
        USCurrency us_currency = new USCurrency();
        FlightPriceCurrency Ifpc = new INRCurrency();
        FlightPriceCurrency Cfpc = new CanadaCurrency();
  

        FlightPriceCurrency c_adapter = new CurrencyAdapter(us_currency);
  
        System.out.println("US Currency...LegacyAPI");
        us_currency.showpriceCurrency(10);
  
        System.out.println("Flight Price in INR Currency...Client API");
        Ifpc.showcurrency(10);
  
        System.out.println("Flight Price in Canadian Dollar Currency...Client API");
        Cfpc.showcurrency(10);
        
        System.out.println("CurrencyAdapter...adapter over Legacy API");
        c_adapter.showcurrency(10);
	}
	
}
