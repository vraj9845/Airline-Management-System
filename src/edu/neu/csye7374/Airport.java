package edu.neu.csye7374;
import java.util.*;

public class Airport {
	private static Airport airportInstance = new Airport();
	private List<FlightAPI> flights;
	private List<PersonAPI> customers;
	private Airport() {
		List<FlightAPI> flights = new ArrayList<FlightAPI>();
		List<PersonAPI> customers = new ArrayList<PersonAPI>();
	}
	public static Airport getInstance() {
		return airportInstance;
	}

}
