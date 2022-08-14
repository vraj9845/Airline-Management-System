package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void demo() {
		CsvHandler csv = new CsvHandler();
		csv.getFile("hello.csv");
		List<String> data = new ArrayList<String>();
		data.add("a,b,c");
		data.add("a,b,c");
		data.add("a,b,c");
		csv.addLineData(data, "hello.csv");
		List<String> res = csv.readFile("hello.csv");
		for(String line : res) {
			System.out.println(line + "\n");
		}
	}
}
