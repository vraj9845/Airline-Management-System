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
    public void descent() {
System.out.println("Error: Cannot go to descent state.");
    }

    @Override
    public void offboarding() {
        System.out.println("Error: Cannot go to Off Boarding state.");
    }
}
