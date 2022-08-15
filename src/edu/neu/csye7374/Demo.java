package edu.neu.csye7374;

import edu.neu.csye7374.FlightState;

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
		
<<<<<<< HEAD
		System.out.println("Initial Price of flight"+flights.get(0).getPrice());
		System.out.println("After applying Summer Discount:");
		System.out.println("Price of flight"+summeroffers.CalculateDiscount(flights.get(0).getPrice()));

		
		
=======

>>>>>>> 16c6b472c4a55eba1f2396113a07c3e181a2fbae
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
<<<<<<< HEAD
		
	
		System.out.println("**********************************************");
		
        USCurrency us_currency = new USCurrency();
        FlightPriceCurrency Ifpc = new INRCurrency();
        FlightPriceCurrency Cfpc = new CanadaCurrency();
  
=======

		System.out.println("Price of flight"+offers.CalculateDiscount(flights.get(0).getPrice()));
>>>>>>> 16c6b472c4a55eba1f2396113a07c3e181a2fbae

        FlightPriceCurrency c_adapter = new CurrencyAdapter(us_currency);
  
        System.out.println("US Currency...LegacyAPI");
        us_currency.showpriceCurrency(bookings.get(0).getFlight().getPrice());
  
        System.out.println("Flight Price in INR Currency...Client API");
        Ifpc.showcurrency(bookings.get(0).getFlight().getPrice());
  
        System.out.println("Flight Price in Canadian Dollar Currency...Client API");
        Cfpc.showcurrency(bookings.get(0).getFlight().getPrice());
        
        System.out.println("CurrencyAdapter...adapter over Legacy API");
        c_adapter.showcurrency(bookings.get(0).getFlight().getPrice());
		
		
		

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
