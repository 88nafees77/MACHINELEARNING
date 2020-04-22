package com.services.simpleregression;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile implements IReader {

	private String csvFile;

	public ReadFromFile(String path) {
		this.csvFile = path;
	}

	public List<String[]> inputReader(String splitBy) {
		List<String[]> input = new ArrayList<String[]>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = splitBy;

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] values = line.split(cvsSplitBy);
				input.add(values);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return input;

	}

}
