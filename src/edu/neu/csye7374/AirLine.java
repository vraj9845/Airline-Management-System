package edu.neu.csye7374;

import java.util.List;

public class AirLine {
	public String airLineName = null;
	public SaveAndLoadFacadeAPI dataHandler;
	public List<FlightAPI> flights;
	public List<PersonAPI> customers;
	public List<Booking> bookings;
	public SaveAndLoadFacadeAPI getDataHandler() {
		return dataHandler;
	}
	public void setDataHandler(SaveAndLoadFacadeAPI dataHandler) {
		this.dataHandler = dataHandler;
		dataHandler.setAirLine(airLineName);
	}
	public List<FlightAPI> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightAPI> flights) {
		this.flights = flights;
	}
	public List<PersonAPI> getCustomers() {
		return customers;
	}
	public void setCustomers(List<PersonAPI> customers) {
		this.customers = customers;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public String getAirLineName() {
		return airLineName;
	}
	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}
	private AirLine() {
	}
	
	public void loadData() {
		flights = dataHandler.loadFlights();
		customers = dataHandler.loadCustomers();
		bookings = dataHandler.loadBookings(customers, flights);
	}

	public void saveFlights(List<FlightAPI> flight){
		dataHandler.saveFlights(flight);
	}

	public void saveCustomers(List<PersonAPI> customer){
		dataHandler.saveCustomers(customer);
	}

	public void saveBooking(List<Booking> booking){
		dataHandler.saveBookings(booking);
	}
	
	public static class AirLineFactory{
		public static AirLine.AirLineFactory instance = new AirLineFactory();
		private AirLineFactory() {
			
		}
		
		public static AirLineFactory getInstance() {
			return instance;
		}
		public AirLine getObject() {
			return new AirLine();
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("customers:");
		sb.append(customers);
		sb.append("flights:");
		sb.append(flights);
		sb.append("bookings:");
		sb.append(bookings);
		return sb.toString();
	}

}
