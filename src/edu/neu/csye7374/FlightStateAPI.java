package src.edu.neu.csye7374;

public interface FlightStateAPI {
    public void onBoarding();
    public void inTransit();
    public void delay();
    public void cancelled();
    public void offboarding();
}
