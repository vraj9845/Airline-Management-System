package edu.neu.csye7374;

import java.util.UUID;

public class BookingBuilder extends Builder{
    private Booking bookingObject = new Booking();

    @Override
    public void buildFlight(){
        bookingObject.setFlight(new Flight.FlightBuilder());
    }

    @Override
    public void buildCustomer(){
        bookingObject.setCustomer(new Customers.CustomersBuilder());
    }

    @Override
    public Booking createBooking(){
        bookingObject.setBookingId(UUID.randomUUID());
        return bookingObject;
    }
}
