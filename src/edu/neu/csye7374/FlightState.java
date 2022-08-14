package src.edu.neu.csye7374;

public class FlightState implements FlightStateAPI{
    private FlightStateAPI flightOnBoarding;
    private FlightStateAPI inTransit;
    private FlightStateAPI descent;
    private FlightStateAPI offBoarding;
    private FlightStateAPI state;

    public FlightState(){
        this.flightOnBoarding = new FlightOnBoarding(this);
        this.inTransit = new FlightInTransit(this);
        this.descent = new FlightDescent(this);
        this.offBoarding = new FlightOffBoarding(this);
        this.state = new FlightOnBoarding(this);
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

    public FlightStateAPI getDescent() {
        return descent;
    }

    public void setDescent(FlightStateAPI descent) {
        this.descent = descent;
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
    public void descent() {
this.state.descent();
    }

    @Override
    public void offboarding() {
this.state.offboarding();
    }

    public static void demoFlightStates(){
        System.out.println("Implementing the state pattern");
        FlightState fs = new FlightState();
        fs.onBoarding();
        fs.inTransit();
        fs.offboarding();
        fs.descent();
        fs.offboarding();
    }
}
