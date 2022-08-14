package src.edu.neu.csye7374;

public class FlightState implements FlightStateAPI{
    private int flightID;
    private FlightStateAPI flightOnBoarding;
    private FlightStateAPI inTransit;
    private FlightStateAPI offBoarding;
    private FlightStateAPI delayed;
    private FlightStateAPI cancelled;
    private FlightStateAPI state;

    public FlightState(){
        this.flightOnBoarding = new FlightOnBoarding(this);
        this.inTransit = new FlightInTransit(this);
        this.offBoarding = new FlightOffBoarding(this);
        this.delayed = new FlightDelayed(this);
        this.cancelled = new FlightCancelled(this);
        this.state = new FlightOnBoarding(this);
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public FlightStateAPI getDelayed() {
        return delayed;
    }

    public void setDelayed(FlightStateAPI delayed) {
        this.delayed = delayed;
    }

    public FlightStateAPI getCancelled() {
        return cancelled;
    }

    public void setCancelled(FlightStateAPI cancelled) {
        this.cancelled = cancelled;
    }

    public FlightStateAPI getFlightOnBoarding() {
        return flightOnBoarding;
    }

    public void setFlightOnBoarding(FlightStateAPI flightOnBoarding) {
        this.flightOnBoarding = flightOnBoarding;
    }

    public FlightStateAPI getInTransit() {
        return inTransit;
    }

    public void setInTransit(FlightStateAPI inTransit) {
        this.inTransit = inTransit;
    }

    public FlightStateAPI getOffBoarding() {
        return offBoarding;
    }

    public void setOffBoarding(FlightStateAPI offBoarding) {
        this.offBoarding = offBoarding;
    }

    public FlightStateAPI getState() {
        return state;
    }

    public void setState(FlightStateAPI state) {
        this.state = state;
    }

    @Override
    public void onBoarding() {
        this.state.onBoarding();
    }

    @Override
    public void inTransit() {
this.state.inTransit();
    }

    @Override
    public void offboarding() {
this.state.offboarding();
    }

    public void delay(){
        this.state.delay();
    }

    public void cancelled(){
        this.state.cancelled();
    }

    public static void demoFlightStates(){
        System.out.println("Implementing the state pattern");
        FlightState fs = new FlightState();
        fs.onBoarding();
        fs.inTransit();
        fs.delay();
        fs.offboarding();
    }
}
