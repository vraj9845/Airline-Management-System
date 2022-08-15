package edu.neu.csye7374;

import src.edu.neu.csye7374.FlightState;

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
		DiscountStrategyAPI offers = new VeteranDiscountStrategy();
		System.out.println("Available Offers and Discounts are:");
		System.out.println(offers.toString());	
		offers = new SummerPromoStrategy();
		System.out.println(offers.toString());
		offers= new ChristmasDiscountStrategy();
		System.out.println(offers.toString());
		
		List<FlightAPI> flights = Qatar.getFlights();
		System.out.println("Initial Price of flight"+flights.get(0).getPrice());
		System.out.println("After applying Christmas Discount:");
		System.out.println("Price of flight"+offers.CalculateDiscount(flights.get(0).getPrice()));
		
		offers = new VeteranDiscountStrategy();
		System.out.println("Initial Price of flight"+flights.get(0).getPrice());
		System.out.println("After applying Veteran's Discount:");
		System.out.println("Price of flight"+offers.CalculateDiscount(flights.get(0).getPrice()));


		System.out.println("Implementing the state pattern");
		FlightState fs = new FlightState(flights.get(0).getFlightID());
		fs.onBoarding();
		fs.inTransit();
		fs.delay();
		fs.offboarding();
		FlightState fs2 = new FlightState(flights.get(1).getFlightID());
		fs2.delay();
		fs2.onBoarding();
		fs2.cancelled();
		fs2.inTransit();
		System.out.println("Flight Scedule status: "+ fs2.isScheduled());
	}
}
