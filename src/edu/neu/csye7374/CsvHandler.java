package edu.neu.csye7374;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvHandler implements FileHandlerAPI {

	@Override
	public File getFile(String fileName) {
		// TODO Auto-generated method stub
		File csvOutputFile = new File(fileName);
		try {
			 boolean res = csvOutputFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvOutputFile;
	}
	
	@Override
	public List<String> readFile(String fileName) {
		List<String> inputArray = new ArrayList<String>();
		if((getFile(fileName))!= null) {
			try {
			FileReader file = new FileReader(fileName);
			BufferedReader in = new BufferedReader(file);
			String nextLine;
			
				while((nextLine = in.readLine())!= null) {
					inputArray.add(nextLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return inputArray;
	}
	public static FileWriter fileWriter(String fileName) {
		try {
			return new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public void addLineData(List<String> lineData, String fileName) {
		FileWriter outputFile = fileWriter(fileName);
		if(outputFile != null) {
			try {
				BufferedWriter out = new BufferedWriter(outputFile);
				for(String nextLine : lineData) {
					out.write(nextLine);
					out.newLine();
				}
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	

}
