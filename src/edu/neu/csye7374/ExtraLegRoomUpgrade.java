package edu.neu.csye7374;
public class ExtraLegRoomUpgrade extends FlightUpgrade{

	public ExtraLegRoomUpgrade(FlightUpgradeImplementation upgradeOptions) {
		super(upgradeOptions);
		// TODO Auto-generated constructor stub
	}
	
	public String basePrice() {
		return super.basePrice() + applyExtraLegRoomCharge();
	}
	
	public String applyExtraLegRoomCharge() {
		return "added 50$ to total bill for extra leg room";
	}
}
