package edu.neu.csye7374;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public interface FileHandlerAPI {
	public File getFile(String fileName);
	public List<String> readFile(String fileName);
	public void addLineData(List<String> lineData, String fileName);
}
