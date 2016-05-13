package onerule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	ArrayList<WeatherData> weather = new ArrayList<WeatherData>();

	// Reads the csv file and populates the arraylist
	public void readFile(File file) throws FileNotFoundException {

		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] lineArray = line.split(",");
			weather.add(new WeatherData(lineArray[0], lineArray[1],
					lineArray[2], lineArray[3], lineArray[4]));
		}
	}
}
