package com.services.machinelearning;

import java.util.List;

import com.services.machinelearning.training.ReaderUtility;
import com.services.machinelearning.training.Training;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Training training = new Training(1f, 1f, 0.05f);
		ReaderUtility readerUtility = new ReaderUtility("C:\\Users\\Nafees Abdullah\\Desktop\\serial.txt");
		List<String[]> list = readerUtility.reader(",");
		list.remove(0);
		int i = 0;
		float x[] = new float[list.size()];
		float y[] = new float[list.size()];
		for (String str[] : list) {

			if (str.length == 3) {
				x[i] = (float) Float.parseFloat(str[1]);
				y[i] = (float) Float.parseFloat(str[2]);
				i++;
			}

		}

		training.training(x, y);
	}
}