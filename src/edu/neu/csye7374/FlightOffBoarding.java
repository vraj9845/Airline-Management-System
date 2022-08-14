package src.edu.neu.csye7374;

public class FlightOffBoarding implements FlightStateAPI{
    public static FlightState flightState;

    public FlightOffBoarding(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
        flightState.setState(flightState.getFlightOnBoarding());
        System.out.println("Passengers are On Boarding the plane!");
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
        System.out.println("Flight is already in Off Boarding State!");
    }
}
