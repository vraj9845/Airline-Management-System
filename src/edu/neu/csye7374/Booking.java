package edu.neu.csye7374;

import java.util.UUID;

public class Booking {
    private FlightAPI flight;
    private PersonAPI customer;
    private UUID bookingId;

    public FlightAPI getFlight() {
        return flight;
    }

    public void setFlight(FlightAPI flight) {
        this.flight = flight;
    }

    public PersonAPI getCustomer() {
        return customer;
    }

    public void setCustomer(PersonAPI customer) {
        this.customer = customer;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }
}
