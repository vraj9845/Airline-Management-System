package edu.neu.csye7374;

public class FlightOffBoarding implements FlightStateAPI{
    public static FlightState flightState;

    public FlightOffBoarding(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        flightState.setState(flightState.getFlightOnBoarding());
        System.out.println("Passengers are On Boarding the FlightID: "+flightState.getFlightID());
    }

    @Override
    public void inTransit() {
        System.out.println("Error: Cannot go to In-Transit State.");
    }

    @Override
    public void delay() {
        System.out.println("Error: cannot go to delay state.");
    }

    @Override
    public void cancelled() {
        System.out.println("Error: cannot go to cancelled state.");
    }

    @Override
    public void offboarding() {
        System.out.println("FlightID: "+flightState.getFlightID()+" is already in Off Boarding State!");
    }
}
