package src.edu.neu.csye7374;

public class FlightOnBoarding implements FlightStateAPI{
    public static FlightState flightState;

    public FlightOnBoarding(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        System.out.println("Already On Boarding!.");
    }

    @Override
    public void inTransit() {
        flightState.setState(flightState.getInTransit());
        System.out.println("Flight is in Transit.");
    }

    @Override
    public void delay() {
        flightState.setState(flightState.getDelayed());
        System.out.println("Cannot On board FlightID: "+flightState.getFlightID()+" as flight is delayed.");
    }

    @Override
    public void cancelled() {
        flightState.setState(flightState.getCancelled());
        System.out.println("Cannot On board as flightID: "+ flightState.getFlightID()+" is Cancelled.");
    }


    @Override
    public void offboarding() {
        System.out.println("Error: Cannot go to Off Boarding state.");
    }
}
