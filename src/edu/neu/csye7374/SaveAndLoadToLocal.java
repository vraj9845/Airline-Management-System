package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class SaveAndLoadToLocal implements SaveAndLoadFacadeAPI {
	/*
	 * implementation of SaveAndLoadFacadeAPI that saves and loads data locally
	 * manner of saving is specified by implementation of FileHandlerAPI
	 * ObjectsToString is used to convert flight, customer and booking data into csv Strings
	 */
	private FileHandlerAPI fileHandler;
	private ObjectsToString converter = new ObjectsToString();
	private String airLineName;
	
	public SaveAndLoadToLocal(FileHandlerAPI fileHandler) {
		this.fileHandler = fileHandler;
	}
	
	@Override
	public void setAirLine(String airLineName) {
		this.airLineName = airLineName;
	}

	@Override
	public void saveFlights(List<FlightAPI> flights) {
		// TODO Auto-generated method stub
		List<String> flightString = new ArrayList<String>();
		for(FlightAPI flight : flights) {
			flightString.add(converter.FlightToString(flight));
		}
//		System.out.println(flightString);
		fileHandler.addLineData(flightString, airLineName+"Flights.csv");
	}

	@Override
	public void saveCustomers(List<PersonAPI> customers) {
		// TODO Auto-generated method stub
		List<String> customerString = new ArrayList<String>();
		for(PersonAPI customer : customers) {
			customerString.add(converter.CustomerToString(customer));
		}
//		System.out.println(customerString);
		fileHandler.addLineData(customerString, airLineName+"Customers.csv");

	}
	
	@Override
	public void saveBookings(List<Booking> bookings) {
		List<String> bookingString = new ArrayList<String>();
		for(Booking booking : bookings) {
			bookingString.add(converter.BookingToString(booking));
		}
//		System.out.println(bookingString);
		fileHandler.addLineData(bookingString, airLineName+"Bookings.csv");
	}

	@Override
	public List<FlightAPI> loadFlights() {
		// TODO Auto-generated method stub
		List<String> flightString = fileHandler.readFile(airLineName+"Flights.csv");
		List<FlightAPI> flights = new ArrayList<FlightAPI>();
		for(String flightStr : flightString) {
			flights.add(converter.StringToFlight(flightStr));
		}
		return flights;
	}

	@Override
	public List<PersonAPI> loadCustomers() {
		// TODO Auto-generated method stub
		List<String> customerString = fileHandler.readFile(airLineName+"Customers.csv");
		List<PersonAPI> customers = new ArrayList<PersonAPI>();
		for(String customerStr : customerString) {
			customers.add(converter.StringToCustomer(customerStr));
		}
		return customers;
	}
	
	@Override
	public List<Booking> loadBookings(List<PersonAPI> customers, List<FlightAPI> flights){
		List<String> bookingString = fileHandler.readFile(airLineName+"Bookings.csv");
		List<Booking> bookings = new ArrayList<Booking>();
		for(String bookingStr : bookingString) {
			bookings.add(converter.StringToBooking(bookingStr, customers, flights));
		}
		return bookings;
	}
}
