package edu.neu.csye7374;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
	public static void demo() throws ParseException {
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

		//Create object using Builder Pattern
		Date date = new SimpleDateFormat("MM-dd-yyyy").parse("12-01-2022");
		List<FlightAPI> flightList = new ArrayList<>();
		flightList.add(new Flight.FlightBuilder()
				.setFlightID(4)
				.setFlightDate(date)
				.setPrice(3000)
				.setStartSite("Boston")
				.setArriveSite("Iceland")
				.createFlight());
		Qatar.saveFlights(flightList);

		List<PersonAPI> customersList = new ArrayList<>();
		customersList.add(new Customers.CustomersBuilder()
				.setCustomerID(4)
				.setFirstName("john")
				.setLastName("jur")
				.setBirthYear(1997)
				.setBirthMonth(10)
				.setBirthDay(28)
				.createCustomers());
		Qatar.saveCustomers(customersList);

		List<Booking> bookings = new ArrayList<>();
		Booking booking = new Booking();
		booking.setFlight(Qatar.getFlights().get(1));
		booking.setCustomer(Qatar.getCustomers().get(0));
		booking.setBookingId(4);
		bookings.add(booking);
		Qatar.saveBooking(bookings);

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
	}
}
