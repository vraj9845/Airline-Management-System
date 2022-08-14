package edu.neu.csye7374;

import java.util.UUID;

public class Booking {
    private Flight.FlightBuilder flight;
    private Customers.CustomersBuilder customer;
    private UUID bookingId;

    public Flight.FlightBuilder getFlight() {
        return flight;
    }

    public void setFlight(Flight.FlightBuilder flight) {
        this.flight = flight;
    }

    public Customers.CustomersBuilder getCustomer() {
        return customer;
    }

    public void setCustomer(Customers.CustomersBuilder customer) {
        this.customer = customer;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }
}
