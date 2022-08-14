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
