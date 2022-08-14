package src.edu.neu.csye7374;

public class FlightCancelled implements FlightStateAPI{
    public static FlightState flightState;

    public FlightCancelled(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public void onBoarding() {
System.out.println("Error: Cannot go to On Boarding state. Flight is Cancelled.");
    }

    @Override
    public void inTransit() {
        System.out.println("Error: Cannot go to In Transit state. Flight is Cancelled.");
    }

    @Override
    public void delay() {
        System.out.println("Error: Cannot go to Delay state. Flight is Cancelled.");
    }

    @Override
    public void cancelled() {
System.out.println("Already in Cancelled state.");
    }

    @Override
    public void offboarding() {
        System.out.println("Error: Cannot go to Off Boarding state. Flight is Cancelled.");
    }
}
