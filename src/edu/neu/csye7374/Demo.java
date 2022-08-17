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
//
		fs.delay();
		fs.offboarding();
		fs.onBoarding();
		//
		fs.inTransit();
		fs.onBoarding();
//		
		fs.inTransit();
		fs.delay();
		//
		fs.offboarding();
	
		fs.onBoarding();
		fs.inTransit();
		fs.delay();
		fs.cancelled();
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


/*
 ******************** OUTPUT  ********************
 * 
 * 
	Create airline by Singleton Factory...

	Create airline by Singleton Factory... done!

	Load data by Facade Pattern...
implementation of FileHandlerAPI created to handle saving flight, customer and booking
CsvHandler stores data in csv format
implementation of FileHandlerAPI created to store/load data in specified machine
SaveAndLoadToLocal manages data locally
data handling abstracted from AirLine object by simply encapsulating complexities in dataHandler object
data loaded
customers:[name: first last
ID: 1
birthday: 3-2-1990
, name: abcd efgh
ID: 2
birthday: 4-3-1995
, name: hiral vraj
ID: 3
birthday: 6-5-2000
, name: john jur
ID: 4
birthday: 28-10-1997
, name: john jur
ID: 4
birthday: 28-10-1997
, name: john jur
ID: 4
birthday: 28-10-1997
, name: john jur
ID: 4
birthday: 28-10-1997
, name: john jur
ID: 4
birthday: 28-10-1997
, name: john jur
ID: 4
birthday: 28-10-1997
]flights:[FlightID: 1 .price: 1500.0$
date: Sun Dec 12 00:00:00 EST 2021
Boston -> Mumbai, FlightID: 2 .price: 1800.0$
date: Thu Jan 05 00:00:00 EST 2023
Boston -> Pacific, FlightID: 3 .price: 2000.0$
date: Fri Jun 06 00:00:00 EDT 2025
Atlantic -> Moon, FlightID: 4 .price: 3000.0$
date: Thu Dec 01 00:00:00 EST 2022
Boston -> Iceland, FlightID: 4 .price: 3000.0$
date: Thu Dec 01 00:00:00 EST 2022
Boston -> Iceland, FlightID: 4 .price: 3000.0$
date: Thu Dec 01 00:00:00 EST 2022
Boston -> Iceland, FlightID: 4 .price: 3000.0$
date: Thu Dec 01 00:00:00 EST 2022
Boston -> Iceland, FlightID: 4 .price: 3000.0$
date: Thu Dec 01 00:00:00 EST 2022
Boston -> Iceland, FlightID: 4 .price: 3000.0$
date: Thu Dec 01 00:00:00 EST 2022
Boston -> Iceland]bookings:[flightID: 1customerID: 1bookingID: 1, flightID: 2customerID: 2bookingID: 2, flightID: 3customerID: 3bookingID: 3, flightID: 2customerID: 1bookingID: 4, flightID: 1customerID: 2bookingID: 4, flightID: 2customerID: 1bookingID: 4, flightID: 1customerID: 2bookingID: 4, flightID: 2customerID: 1bookingID: 4, flightID: 1customerID: 2bookingID: 4]

	Load data by Facade Pattern... done!

	Create Flights and Customers Object by Builder Pattern...

	Create Flights and Customers Object by Builder Pattern... done!

	Save data to csv file by Facade Pattern...

	Save data to csv file by Facade Pattern...done!

	Create new booking object...

	Create new booking object... done!

	Save booking data to csv file by Facade Pattern...

	Save booking data to csv file by Facade Pattern... done!

	Show discounts and promo by Strategy Pattern...
Available Offers and Discounts are:
Veteran_Discount of 50%
Summer_Promo off by 150
Christmas_Discount of 10%
Initial Price of flight1500.0
After applying Christmas Discount:
Price of flight1350.0
Initial Price of flight1500.0
After applying Summer Discount:
Price of flight1350.0
Initial Price of flight1500.0
After applying Veteran's Discount:
Price of flight750.0
details of flight oneFlightID: 1 .price: 1500.0$
date: Sun Dec 12 00:00:00 EST 2021
Boston -> Mumbai
details of bookingflightID: 1customerID: 1bookingID: 1
After applying Veteran's Discount:
Price of flight750.0

	Show discounts and promo by Strategy Pattern... done!

	Add extra services for booking by Decorator Pattern...
details of flight 1. FlightID: 1 .price: 750.0$
date: Sun Dec 12 00:00:00 EST 2021
Boston -> Mumbai
details of bookingflightID: 1customerID: 1bookingID: 1Price :750.0
Base price of the flight added 250$ to total bill for premium upgrade
details of bookingflightID: 1customerID: 1bookingID: 1Price :1000.0
details of flight 2. FlightID: 2 .price: 1800.0$
date: Thu Jan 05 00:00:00 EST 2023
Boston -> Pacific
details of bookingflightID: 2customerID: 2bookingID: 2Price :1800.0
Base price of the flight added 100$ to total bill for extra luggage
details of bookingflightID: 2customerID: 2bookingID: 2Price :1900.0
details of flight 3. FlightID: 3 .price: 2000.0$
date: Fri Jun 06 00:00:00 EDT 2025
Atlantic -> Moon
details of bookingflightID: 3customerID: 3bookingID: 3Price :2000.0
Base price of the flight added 100$ to total bill for extra luggage added 250$ to total bill for premium upgrade
details of bookingflightID: 3customerID: 3bookingID: 3Price :2350.0

	Add extra services for booking by Decorator Pattern... done!

	Show flight prices in different currencies by Adapter Pattern...
US Currency...LegacyAPI
Flight Price in US Dollars: 1000.0
Flight Price in INR Currency...Client API
Flight Price in INR:79200.0
Flight Price in Canadian Dollar Currency...Client API
Flight Price in Canadian Dollars:1280.0
CurrencyAdapter...adapter over Legacy API
Flight Price in US Dollars: 1000.0

	Show flight prices in different currencies by Adapter Pattern... done!

	Change flights states by State Pattern...
FlightID:1 Is now scheduled.
FlightID: 1 On Boarding!.
Cannot On board FlightID: 1 as flight is delayed.
Sorry for Delay, FlightID: 1 is now Off Boarding.
Passengers are On Boarding the FlightID: 1
FlightID: 1 is in Transit.
Error: Cannot go to On Boarding state.
FLightID: 1 Already in Transit!
Error: cannot go to delay state.
FlightID: 1 is offBoarding.
Passengers are On Boarding the FlightID: 1
FlightID: 1 is in Transit.
Error: cannot go to delay state.
Error: cannot go to cancelled state.
FlightID: 1 is offBoarding.
FlightID:2 Is now scheduled.
Cannot On board FlightID: 2 as flight is delayed.
Sorry for Delay, FlightID: 2 is now On Boarding.
Cannot On board as flightID: 2 is Cancelled.
Error: Cannot go to In Transit state. Flight is Cancelled.
Flight Schedule status: false

	Change flights states by State Pattern... done!
 * 
*/