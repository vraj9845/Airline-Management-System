package edu.neu.csye7374;

import java.util.UUID;

public class Booking {
    private FlightAPI flight;
    private PersonAPI customer;
    private UUID bookingId;

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

    public UUID getBookingId() {
        return bookingId;
    }

    public Booking setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
        return this;
    }
}
