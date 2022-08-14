package edu.neu.csye7374;

public class AmericanAirlinesFactoryEagerSingleton extends AbstractFactory {
	private static Flight instance = new AmericanAirlines();
	
	private AmericanAirlinesFactoryEagerSingleton() {}
	
	public static Flight getInstance() {
		return instance;
	}
}
