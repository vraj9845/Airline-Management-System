package src.edu.neu.csye7374;

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
System.out.println("Already in Transit!");
    }

    @Override
    public void descent() {
        flightState.setState(flightState.getDescent());
        System.out.println("Flight is descending now Closed.");
    }

    @Override
    public void offboarding() {
        System.out.println("Error: Cannot go to Off Boarding state.");
    }
}
