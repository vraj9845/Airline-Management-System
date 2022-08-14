package edu.neu.csye7374;

public class ObjectsToString {
	public String FlightToString(Flight flight) {
		StringBuilder sb = new StringBuilder();
		sb.append(flight.getFlightID() + ',');
		sb.append(flight.getPrice() + ',');
		sb.append(flight.getStartSite() + ',');
		sb.append(flight.getArriveSite() + ',');
		sb.append(flight.getFlightDate().toString() + ',');
		return sb.toString();
	}
	
}
