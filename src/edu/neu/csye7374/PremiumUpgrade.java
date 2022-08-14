package edu.neu.csye7374;
public class PremiumUpgrade extends FlightUpgrade{
	
	public PremiumUpgrade(FlightUpgradeImplementation upgradeOptions) {
		super(upgradeOptions);
	}
	
	public String basePrice() {
		return super.basePrice() + applyPremiumCharge();
	}
	
	public String applyPremiumCharge() {
		return "added 250$ to total bill for premium upgrade";
	}

}
