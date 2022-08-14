package edu.neu.csye7374;

public class UnitedAirlinesFactoryLazySingleton extends AbstractFactory {
	private static Flight instance;

	private UnitedAirlinesFactoryLazySingleton() {
		instance = null;
	}

	public static synchronized Flight getInstance() {
		if (instance == null) {
			instance = new UnitedAirlines();
		}
		return instance;
	}

}
