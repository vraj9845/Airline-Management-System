package edu.neu.csye7374;

import java.util.Date;

public class Flight implements FlightAPI{
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
}
