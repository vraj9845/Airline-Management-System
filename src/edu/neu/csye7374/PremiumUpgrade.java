package edu.neu.csye7374;
public class PremiumUpgrade extends FlightUpgrade{
	double premiumCharge = 250.0;
	public PremiumUpgrade(FlightUpgradeOptions upgradeOptions) {
		super(upgradeOptions);
	}
	
	public double getBasePrice() {
		return this.upgradeOptions.getBasePrice() + premiumCharge;
	}
	
	public String getUpgradeDescription() {
		return this.upgradeOptions.getUpgradeDescription() + " added 250$ to total bill for premium upgrade";
	}

}
