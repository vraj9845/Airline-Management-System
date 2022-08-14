package edu.neu.csye7374;

public class BookingBuilder extends Builder{
    private Booking bookingObject = new Booking();

    @Override
    public void buildFlight(){
        bookingObject.setFlight(new Flight());
    }

    @Override
    public void buildCustomer(){
        bookingObject.setCustomer(new Customers());
    }

    public void addBookingId(){
        //TODO: Create bookingID
        bookingObject.setBookingId(bookingObject.getBookingId());
    }

    @Override
    public Booking createBooking(){
        return bookingObject;
    }
}
