package edu.neu.csye7374;

import java.util.List;

public class SaveToLocal implements SaveAndLoadFacadeAPI {
	private FileHandlerAPI fileHandler;
	
	public SaveToLocal(FileHandlerAPI fileHandler) {
		this.fileHandler = fileHandler;
	}

	@Override
	public void saveFlights(List<FlightAPI> flights) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCustomers(List<PersonAPI> customers) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FlightAPI> loadFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonAPI> loadCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
