package edu.neu.csye7374;

import edu.neu.csye7374.FlightState;


import java.text.ParseException;

public class Driver {

	public static void main(String[] args) throws ParseException {

		
		Demo.demo();

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