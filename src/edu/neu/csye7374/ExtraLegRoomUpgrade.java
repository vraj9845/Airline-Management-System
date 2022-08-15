package edu.neu.csye7374;
public class ExtraLegRoomUpgrade extends FlightUpgrade{
	double extraLegRoomCharge = 50;
	public ExtraLegRoomUpgrade(FlightUpgradeOptions upgradeOptions) {
		super(upgradeOptions);
	}
	
	public double basePrice() {
		return this.upgradeOptions.getBasePrice() + extraLegRoomCharge;
	}
	
	public String getUpgradeDescription() {
		return this.upgradeOptions.getUpgradeDescription() + " added 50$ to total bill for extra leg room";
	}
}
