package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
	public static void demo() {
		AirLine.AirLineFactory airLineFactory = AirLine.AirLineFactory.getInstance();
		AirLine United = airLineFactory.getObject();
		
		FileHandlerAPI csvHandler = new CsvHandler();
		SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);
//		United.setAirLineName("United");
		AirLine Qatar = airLineFactory.getObject();
		Qatar.setAirLineName("Qatar");
		Qatar.setDataHandler(dataHandler);
		
//		United.loadData();
		Qatar.loadData();
		System.out.println(Qatar);
	}
}
