package edu.neu.csye7374;

import java.util.Date;

public class Flight implements FlightAPI{
    private int flightID;
    private double price;
    private Date flightDate;
    private String startSite;
    private String arriveSite;
    private Flight(FlightBuilder fb) {
    	this.flightID = fb.getFlightID();
    	this.price = fb.getPrice();
    	this.flightDate = fb.getFlightDate();
    	this.startSite = fb.getStartSite();
    	this.arriveSite = fb.getArriveSite();
    }

    public int getFlightID() {
        return flightID;
    }

    public double getPrice() {
        return price;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getStartSite() {
        return startSite;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public static class FlightBuilder {
    	private int flightID;
		private double price;
        private Date flightDate;
        private String startSite;
        private String arriveSite;
    	public int getFlightID() {
			return flightID;
		}
		public double getPrice() {
			return price;
		}
		public Date getFlightDate() {
			return flightDate;
		}
		public String getStartSite() {
			return startSite;
		}
		public String getArriveSite() {
			return arriveSite;
		}
		public FlightBuilder setFlightID(int flightID) {
			this.flightID = flightID;
			return this;
		}
		public FlightBuilder setPrice(double price) {
			this.price = price;
			return this;
		}
		public FlightBuilder setFlightDate(Date flightDate) {
			this.flightDate = flightDate;
			return this;
		}
		public FlightBuilder setStartSite(String startSite) {
			this.startSite = startSite;
			return this;
		}
		public FlightBuilder setArriveSite(String arriveSite) {
			this.arriveSite = arriveSite;
			return this;
		}
		public Flight createFlight() {
			return new Flight(this);
		}
    }
}
