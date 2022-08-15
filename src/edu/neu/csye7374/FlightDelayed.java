package edu.neu.csye7374;

public class FlightDelayed implements FlightStateAPI{
    public static FlightState flightState;

    public FlightDelayed(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        flightState.setState(flightState.getFlightOnBoarding());
        System.out.println("Sorry for Delay, FlightID: " + flightState.getFlightID() + " is now On Boarding.");
    }

    @Override
    public void inTransit() {
System.out.println("Error: Cannot go to in Transit state.");
    }

    @Override
    public void delay() {
System.out.println("FlightID: "+ flightState.getFlightID()+" Already in Delay state.");
    }

    @Override
    public void cancelled() {
        flightState.setState(flightState.getCancelled());
        System.out.println("FlightID: "+ flightState.getFlightID() + " is Cancelled.");
    }

    @Override
    public void offboarding() {
        flightState.setState(flightState.getOffBoarding());
        System.out.println("Sorry for Delay, FlightID: "+flightState.getFlightID() +" is now Off Boarding.");
    }
}
