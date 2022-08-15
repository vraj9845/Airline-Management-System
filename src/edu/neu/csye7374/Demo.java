package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
	public static void demo() {
		AirLine.AirLineFactory airLineFactory = AirLine.AirLineFactory.getInstance();
		AirLine United = airLineFactory.getObject();
		
		FileHandlerAPI csvHandler = new CsvHandler();
		SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);
//		United.setAirLineName("United");
		AirLine Qatar = airLineFactory.getObject();
		Qatar.setAirLineName("Qatar");
		Qatar.setDataHandler(dataHandler);
		
//		United.loadData();
		Qatar.loadData();
		System.out.println(Qatar);
		
		//Available Discounts and Promo
		DiscountStrategyAPI Voffers = new VeteranDiscountStrategy();
		System.out.println("Available Offers and Discounts are:");
		System.out.println(Voffers.toString());	
		DiscountStrategyAPI summeroffers = new SummerPromoStrategy();
		System.out.println(summeroffers.toString());
		DiscountStrategyAPI Coffers= new ChristmasDiscountStrategy();
		System.out.println(Coffers.toString());
		
		List<FlightAPI> flights = Qatar.getFlights();
		System.out.println("Initial Price of flight"+flights.get(0).getPrice());
		System.out.println("After applying Christmas Discount:");
		System.out.println("Price of flight"+Coffers.CalculateDiscount(flights.get(0).getPrice()));
		
		
		System.out.println("Initial Price of flight"+flights.get(0).getPrice());
		System.out.println("After applying Veteran's Discount:");
		System.out.println("Price of flight"+Voffers.CalculateDiscount(flights.get(0).getPrice()));
		
		List<Booking> bookings = Qatar.getBookings();
		System.out.println("details of flight one"+flights.get(0).toString());
		System.out.println("details of booking" + bookings.get(0).toString());
		bookings.get(0).getFlight().setPrice(Voffers.CalculateDiscount(flights.get(0).getPrice()));
		System.out.println("After applying Veteran's Discount:");
		System.out.println("Price of flight"+flights.get(0).getPrice());
		
		
		
		System.out.println("**********************************************");
//		
		System.out.println("details of flight one"+flights.get(0).toString());
		System.out.println("details of booking" + bookings.get(0).toString() + "Price :" + bookings.get(0).getFlight().getPrice() );
		FlightUpgradeOptions f1 = new PremiumUpgrade(new FlightUpgradeImplementation(bookings.get(0)));
		System.out.println(f1.getUpgradeDescription());
		bookings.get(0).getFlight().setPrice(f1.getBasePrice());
		System.out.println("details of booking" + bookings.get(0).toString() + "Price :" + bookings.get(0).getFlight().getPrice() );
		
		
		System.out.println("details of flight one"+flights.get(1).toString());
		System.out.println("details of booking" + bookings.get(1).toString() + "Price :" + bookings.get(1).getFlight().getPrice() );
		FlightUpgradeOptions f2 = new ExtraLuggageUpgrade(new FlightUpgradeImplementation(bookings.get(1)));
		System.out.println(f2.getUpgradeDescription());
		bookings.get(1).getFlight().setPrice(f2.getBasePrice());
		System.out.println("details of booking" + bookings.get(1).toString() + "Price :" + bookings.get(1).getFlight().getPrice() );
		
		System.out.println("details of flight one"+flights.get(2).toString());
		System.out.println("details of booking" + bookings.get(2).toString() + "Price :" + bookings.get(2).getFlight().getPrice() );
		FlightUpgradeOptions f3 = new PremiumUpgrade(new ExtraLuggageUpgrade(new FlightUpgradeImplementation(bookings.get(2))));
		System.out.println(f3.getUpgradeDescription());
		bookings.get(2).getFlight().setPrice(f3.getBasePrice());
		System.out.println("details of booking" + bookings.get(2).toString() + "Price :" + bookings.get(2).getFlight().getPrice() );
		
	}
}
