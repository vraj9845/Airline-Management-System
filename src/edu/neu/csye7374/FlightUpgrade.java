package edu.neu.csye7374;
public class FlightUpgrade implements FlightUpgradeOptions{
	FlightUpgradeOptions upgradeOptions;
	
	public FlightUpgrade(FlightUpgradeOptions upgradeOptions) {
		this.upgradeOptions = upgradeOptions;
	}
	
    @Override
    public double getBasePrice() {
        return this.upgradeOptions.getBasePrice();
    }
    
	@Override
	public String getUpgradeDescription() {
		
		return this.upgradeOptions.getUpgradeDescription();
	}
}
