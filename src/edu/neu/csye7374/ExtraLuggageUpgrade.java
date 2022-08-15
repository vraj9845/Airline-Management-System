package edu.neu.csye7374;
public class ExtraLuggageUpgrade extends FlightUpgrade{
	double extraLuggageCharge = 100.0;
	public ExtraLuggageUpgrade(FlightUpgradeOptions upgradeOptions) {
		super(upgradeOptions);	
	}
	
	public double getBasePrice() {
		return this.upgradeOptions.getBasePrice() + extraLuggageCharge;
	}
	
	public String getUpgradeDescription() {
		return this.upgradeOptions.getUpgradeDescription() + " added 100$ to total bill for extra luggage";
	}

}
