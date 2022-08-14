package edu.neu.csye7374;

public class Booking {
    private FlightAPI flight;
    private PersonAPI customer;
    private Long bookingId;

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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
