package edu.neu.csye7374;

import java.util.List;

public interface SaveAndLoadFacadeAPI {
	/*
	 * API to abstract data persistence of flight, customer and booking data
	 */
	void setAirLine(String airLineName);
	void saveFlights(List<FlightAPI> flights);
	void saveCustomers(List<PersonAPI> customers);
	void saveBookings(List<Booking> bookings);

	List<FlightAPI> loadFlights();
	List<PersonAPI> loadCustomers();
	List<Booking> loadBookings(List<PersonAPI> customers, List<FlightAPI> flights);
}