package edu.neu.csye7374;

public class FlightInTransit implements FlightStateAPI{
    public static FlightState flightState;

    public FlightInTransit(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        System.out.println("Error: Cannot go to On Boarding state.");
    }

    @Override
    public void inTransit() {
System.out.println("FLightID: " +flightState.getFlightID() + " Already in Transit!");
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
    	 flightState.setState(flightState.getOffBoarding());
         System.out.println("FlightID: "+ flightState.getFlightID()+" is offBoarding.");
    }
}
