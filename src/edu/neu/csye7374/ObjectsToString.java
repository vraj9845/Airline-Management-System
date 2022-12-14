package edu.neu.csye7374;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import edu.neu.csye7374.Customers.CustomersBuilder;
import edu.neu.csye7374.Flight.FlightBuilder;

public class ObjectsToString {
	/*
	 * ObjectsToString is used to convert flight, customer and booking data into csv Strings
	 */
	public String FlightToString(FlightAPI flight) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(flight.getFlightID()) + ',');
		sb.append(String.valueOf(flight.getPrice()) + ',');
		sb.append(flight.getStartSite() + ',');
		sb.append(flight.getArriveSite() + ',');
		sb.append(new SimpleDateFormat("dd/MM/yyyy").format(flight.getFlightDate()));
//		sb.append(flight.getFlightDate().toString());
//		System.out.println(flight);
//		System.out.println(sb);
		return sb.toString();
	}
	
	public FlightAPI StringToFlight(String src) {
		String[] s = src.split(",");
		Flight.FlightBuilder fb = new FlightBuilder();
		
		try {
			fb.setFlightID(Integer.valueOf(s[0]));
			fb.setPrice(Double.valueOf(s[1]));
			fb.setStartSite(s[2]);
			fb.setArriveSite(s[3]);
			fb.setFlightDate(new SimpleDateFormat("dd/MM/yyyy").parse(s[4]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fb.createFlight();
	}
	
	public String CustomerToString(PersonAPI customer) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(customer.getCustomerID()) + ',');
		sb.append(customer.getFirstName() + ',');
		sb.append(customer.getLastName() + ',');
		sb.append(String.valueOf(customer.getBirthYear()) + ',');
		sb.append(String.valueOf(customer.getBirthMonth()) + ',');
		sb.append(String.valueOf(customer.getBirthDay()));
		
		return sb.toString();
	}
	
	public PersonAPI StringToCustomer(String src) {
		String[] s = src.split(",");
		Customers.CustomersBuilder cb = new CustomersBuilder();
		
		try {
			cb.setCustomerID(Integer.valueOf(s[0]));
			cb.setFirstName(s[1]);
			cb.setLastName(s[2]);
			cb.setBirthYear(Integer.valueOf(s[3]));
			cb.setBirthMonth(Integer.valueOf(s[4]));
			cb.setBirthDay(Integer.valueOf(s[5]));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cb.createCustomers();
	}
	
	public String BookingToString(Booking booking) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(booking.getBookingId()) + ',');
		sb.append(String.valueOf(booking.getFlight().getFlightID()) + ',');
		sb.append(String.valueOf(booking.getCustomer().getCustomerID()));
		return sb.toString();
	}
	
	public Booking StringToBooking(String src, List<PersonAPI> customers, List<FlightAPI> flights) {
		String[] s = src.split(",");
		Booking booking = new Booking();
		try {
			booking.setBookingId(Integer.valueOf(s[0]));
			int customerID = Integer.valueOf(s[1]);
			int flightID = Integer.valueOf(s[2]);
			PersonAPI customer = null;
			FlightAPI flight = null;
			for(PersonAPI c : customers) {
				if(c.getCustomerID() == customerID) {
					customer = c;
					break;
				}
			}
			
			booking.setCustomer(customer);
			for(FlightAPI f : flights) {
				if(f.getFlightID() == flightID) {
					flight = f;
					break;
				}
			}
			booking.setFlight(flight);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;
	}
}
