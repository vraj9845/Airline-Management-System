package edu.neu.csye7374;
public class FlightUpgrade extends FlightUpgradeImplementation{
	FlightUpgradeOptions upgradeOptions = null;
	
	public FlightUpgrade(FlightUpgradeImplementation upgradeOptions) {
		super();
		this.upgradeOptions = upgradeOptions;
	}
	
    @Override
    public String basePrice() {
        return upgradeOptions.basePrice();
    }
}
