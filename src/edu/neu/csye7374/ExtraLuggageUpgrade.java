package edu.neu.csye7374;
public class ExtraLuggageUpgrade extends FlightUpgrade{
	public ExtraLuggageUpgrade(FlightUpgradeImplementation upgradeOptions) {
		super(upgradeOptions);
		// TODO Auto-generated constructor stub
	}
	
	public String basePrice() {
		return super.basePrice() + applyExtraLuggageCharge();
	}
	
	public String applyExtraLuggageCharge() {
		return "added 100$ to total bill for extra luggage";
	}

}
