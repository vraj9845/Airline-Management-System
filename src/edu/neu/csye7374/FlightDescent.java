package src.edu.neu.csye7374;

public class FlightDescent implements FlightStateAPI{

    public static FlightState flightState;

    public FlightDescent(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        System.out.println("Error: Cannot go to On Boarding State.");
    }

    @Override
    public void inTransit() {
        System.out.println("Error: Cannot go to In-Transit State.");
    }

    @Override
    public void descent() {
System.out.println("Flight is already in Descent State!");
    }

    @Override
    public void offboarding() {
        flightState.setState(flightState.getOffBoarding());
        System.out.println("Passengers are off boarding the plane!");
    }
}
