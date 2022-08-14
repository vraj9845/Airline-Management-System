package edu.neu.csye7374;

import java.util.List;

public interface SaveAndLoadFacadeAPI {
	void saveFlights(List<FlightAPI> flights);
	void saveCustomers(List<PersonAPI> customers);

	List<FlightAPI> loadFlights();
	List<PersonAPI> loadCustomers();
}
