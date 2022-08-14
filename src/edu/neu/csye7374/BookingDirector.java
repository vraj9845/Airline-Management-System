package edu.neu.csye7374;

public class BookingDirector {
    private Builder bookingBuilder = null;

    public BookingDirector(Builder builder){
        bookingBuilder = builder;
    }
    public Booking construct(){
        bookingBuilder.buildFlight();
        bookingBuilder.buildCustomer();
        return bookingBuilder.createBooking();
    }
}
