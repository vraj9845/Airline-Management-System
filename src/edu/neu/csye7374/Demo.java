package edu.neu.csye7374;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
	/*
	 * contains only static demo() method to showcase all design patterns and intended program workflow
	 * console output reflects working of the demo() method
	 */
	public static void demo() throws ParseException {
		System.out.println("\n\t" + "Create airline by Singleton Factory...");

		AirLine.AirLineFactory airLineFactory = AirLine.AirLineFactory.getInstance();
		AirLine Qatar = airLineFactory.getObject();
		Qatar.setAirLineName("Qatar");

		System.out.println("\n\t" + "Create airline by Singleton Factory... done!");

		System.out.println("\n\t" + "Load data by Facade Pattern...");
		
		
		//implementation of FileHandlerAPI created to handle saving flight, customer and booking
		System.out.println("implementation of FileHandlerAPI created to handle saving flight, customer and booking");
		//CsvHandler stores data in csv format
		System.out.println("CsvHandler stores data in csv format");
		FileHandlerAPI csvHandler = new CsvHandler();
		
		//implementation of FileHandlerAPI created to store/load data in specified machine
		System.out.println("implementation of FileHandlerAPI created to store/load data in specified machine");
		//SaveAndLoadToLocal manages data locally
		System.out.println("SaveAndLoadToLocal manages data locally");
		SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);
		
		//data handling abstracted from AirLine object by simply encapsulating complexities in dataHandler object
		System.out.println("data handling abstracted from AirLine object by simply encapsulating complexities in dataHandler object");
		Qatar.setDataHandler(dataHandler);
		
		//data loaded
		Qatar.loadData();
		System.out.println("data loaded");
		System.out.println(Qatar);

		System.out.println("\n\t" + "Load data by Facade Pattern... done!");

		System.out.println("\n\t" + "Create Flights and Customers Object by Builder Pattern...");

		Date date = new SimpleDateFormat("MM-dd-yyyy").parse("12-01-2022");
		List<FlightAPI> flightList = new ArrayList<>();
		flightList.add(new Flight.FlightBuilder()
				.setFlightID(4)
				.setFlightDate(date)
				.setPrice(3000)
				.setStartSite("Boston")
				.setArriveSite("Iceland")
				.createFlight());

		List<PersonAPI> customersList = new ArrayList<>();
		customersList.add(new Customers.CustomersBuilder()
				.setCustomerID(4)
				.setFirstName("john")
				.setLastName("jur")
				.setBirthYear(1997)
				.setBirthMonth(10)
				.setBirthDay(28)
				.createCustomers());
		System.out.println("\n\t" + "Create Flights and Customers Object by Builder Pattern... done!");

		System.out.println("\n\t" + "Save data to csv file by Facade Pattern...");

		Qatar.saveFlights(flightList);
		Qatar.saveCustomers(customersList);

		System.out.println("\n\t" + "Save data to csv file by Facade Pattern...done!");

		System.out.println("\n\t" + "Create new booking object...");

		List<Booking> bookingsList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setFlight(Qatar.getFlights().get(1));
		booking.setCustomer(Qatar.getCustomers().get(0));
		booking.setBookingId(4);
		bookingsList.add(booking);

		System.out.println("\n\t" + "Create new booking object... done!");

		System.out.println("\n\t" + "Save booking data to csv file by Facade Pattern...");

		Qatar.saveBooking(bookingsList);

		System.out.println("\n\t" + "Save booking data to csv file by Facade Pattern... done!");

		System.out.println("\n\t" + "Show discounts and promo by Strategy Pattern...");

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
		System.out.println("After applying Summer Discount:");
		System.out.println("Price of flight"+summeroffers.CalculateDiscount(flights.get(0).getPrice()));

		System.out.println("Initial Price of flight"+flights.get(0).getPrice());
		System.out.println("After applying Veteran's Discount:");
		System.out.println("Price of flight"+Voffers.CalculateDiscount(flights.get(0).getPrice()));

		List<Booking> bookings = Qatar.getBookings();
		System.out.println("details of flight one"+flights.get(0).toString());
		System.out.println("details of booking" + bookings.get(0).toString());
		bookings.get(0).getFlight().setPrice(Voffers.CalculateDiscount(flights.get(0).getPrice()));
		System.out.println("After applying Veteran's Discount:");
		System.out.println("Price of flight"+flights.get(0).getPrice());

		System.out.println("\n\t" + "Show discounts and promo by Strategy Pattern... done!");

		System.out.println("\n\t" + "Add extra services for booking by Decorator Pattern...");

		System.out.println("details of flight 1. "+flights.get(0).toString());
		System.out.println("details of booking" + bookings.get(0).toString() + "Price :" + bookings.get(0).getFlight().getPrice() );
		FlightUpgradeOptions f1 = new PremiumUpgrade(new FlightUpgradeImplementation(bookings.get(0)));
		System.out.println(f1.getUpgradeDescription());
		bookings.get(0).getFlight().setPrice(f1.getBasePrice());
		System.out.println("details of booking" + bookings.get(0).toString() + "Price :" + bookings.get(0).getFlight().getPrice() );

		System.out.println("details of flight 2. "+flights.get(1).toString());
		System.out.println("details of booking" + bookings.get(1).toString() + "Price :" + bookings.get(1).getFlight().getPrice() );
		FlightUpgradeOptions f2 = new ExtraLuggageUpgrade(new FlightUpgradeImplementation(bookings.get(1)));
		System.out.println(f2.getUpgradeDescription());
		bookings.get(1).getFlight().setPrice(f2.getBasePrice());
		System.out.println("details of booking" + bookings.get(1).toString() + "Price :" + bookings.get(1).getFlight().getPrice() );

		System.out.println("details of flight 3. "+flights.get(2).toString());
		System.out.println("details of booking" + bookings.get(2).toString() + "Price :" + bookings.get(2).getFlight().getPrice() );
		FlightUpgradeOptions f3 = new PremiumUpgrade(new ExtraLuggageUpgrade(new FlightUpgradeImplementation(bookings.get(2))));
		System.out.println(f3.getUpgradeDescription());
		bookings.get(2).getFlight().setPrice(f3.getBasePrice());
		System.out.println("details of booking" + bookings.get(2).toString() + "Price :" + bookings.get(2).getFlight().getPrice() );

		System.out.println("\n\t" + "Add extra services for booking by Decorator Pattern... done!");

		System.out.println("\n\t" + "Show flight prices in different currencies by Adapter Pattern...");

        USCurrency us_currency = new USCurrency();
        FlightPriceCurrency Ifpc = new INRCurrency();
        FlightPriceCurrency Cfpc = new CanadaCurrency();

        FlightPriceCurrency c_adapter = new CurrencyAdapter(us_currency);
  
        System.out.println("US Currency...LegacyAPI");
        us_currency.showpriceCurrency(bookings.get(0).getFlight().getPrice());
  
        System.out.println("Flight Price in INR Currency...Client API");
        Ifpc.showcurrency(bookings.get(0).getFlight().getPrice());
  
        System.out.println("Flight Price in Canadian Dollar Currency...Client API");
        Cfpc.showcurrency(bookings.get(0).getFlight().getPrice());
        
        System.out.println("CurrencyAdapter...adapter over Legacy API");
        c_adapter.showcurrency(bookings.get(0).getFlight().getPrice());

		System.out.println("\n\t" + "Show flight prices in different currencies by Adapter Pattern... done!");
		

		System.out.println("\n\t" + "Change flights states by State Pattern...");

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
		System.out.println("Flight Schedule status: "+ fs2.isScheduled());

		System.out.println("\n\t" + "Change flights states by State Pattern... done!");

	}
}
