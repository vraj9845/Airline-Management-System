package edu.neu.csye7374;

public class Booking {
    private FlightAPI flight;
    private PersonAPI customer;
    private int bookingId;

    public FlightAPI getFlight() {
        return flight;
    }

    public Booking setFlight(FlightAPI flight) {
        this.flight = flight;
        return this;
    }

    public PersonAPI getCustomer() {
        return customer;
    }

    public Booking setCustomer(PersonAPI customer) {
        this.customer = customer;
        return this;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Booking setBookingId(int bookingId) {
        this.bookingId = bookingId;
        return this;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("flightID: " +flight.getFlightID());
    	sb.append("customerID: " + customer.getCustomerID());
    	sb.append("bookingID: " + this.getBookingId());
    	return sb.toString();
    }
}
