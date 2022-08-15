package edu.neu.csye7374;
public class FlightUpgradeImplementation implements FlightUpgradeOptions {
	 Booking booking;
	 public FlightUpgradeImplementation(Booking booking) {
		 super();
		 this.booking = booking;
	 }
	@Override
	public double getBasePrice() {
		return this.booking.getFlight().getPrice();	
	}
	@Override
	public String getUpgradeDescription() {
		return "Base price of the flight";
	}
}
