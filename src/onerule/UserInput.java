package onerule;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
	ArrayList<WeatherData> inputConsole = new ArrayList<WeatherData>();
	WeatherData wd = new WeatherData();
	String newOutlook;
	String newTemp;
	String newHumidity;
	String newWindy;

	// Takes user input values and validates
	public void inputData() {
		System.out.println("Enter the attributes");

		WeatherData wd = new WeatherData();
		Scanner sc = new Scanner(System.in);

		System.out.println("Outlook:");
		while (true) {
			String outlook = sc.nextLine();
			if (outlook.equalsIgnoreCase("Sunny")
					|| outlook.equalsIgnoreCase("Overcast")
					|| outlook.equalsIgnoreCase("Rainy")) {
				wd.setOutlook(outlook);
				newOutlook = wd.getOutlook();
				break;
			} else {
				System.out
						.println("Wrong inputs: Please enter one among (Sunny,Overcast,Rainy)");
				System.out.println("Please enter again");
			}
		}

		System.out.println("Temperature:");
		while (true) {
			String temperature = sc.nextLine();
			if (temperature.equalsIgnoreCase("hot")
					|| temperature.equalsIgnoreCase("mild")
					|| temperature.equalsIgnoreCase("cool")) {
				wd.setTemperature(temperature);
				newTemp = wd.getTemperature();
				break;
			} else {
				System.out
						.println("Wrong inputs: Please enter one among (hot,mild,cool)");
				System.out.println("Please enter again");
			}
		}

		System.out.println("Humidity:");
		while (true) {
			String humidity = sc.nextLine();
			if (humidity.equalsIgnoreCase("high")
					|| humidity.equalsIgnoreCase("normal")) {
				wd.setHumidity(humidity);
				newHumidity = wd.getHumidity();
				break;
			} else {
				System.out
						.println("Wrong inputs: Please enter one among (normal,high)");
				System.out.println("Please enter again");
			}
		}

		System.out.println("Windy:");
		while (true) {
			String windy = sc.nextLine();
			if (windy.equalsIgnoreCase("true")
					|| windy.equalsIgnoreCase("false")) {
				wd.setWindy(windy);
				newWindy = wd.getWindy();
				break;
			} else {
				System.out
						.println("Wrong inputs: Please enter one among (true,false)");
				System.out.println("Please enter again");
			}
		}
	}

	// function to predict the final output
	public void predictOutput(String decidingAttribute) {

		System.out.println("Predicted value is");
		if (decidingAttribute.equals("Outlook")) {
			if (newTemp.equals("Sunny")) {
				System.out.println("Play -> No");
			} else if (newTemp.equals("Overcast")) {
				System.out.println("Play -> Yes");
			} else
				System.out.println("Play -> Yes");
		} else {
			if (newHumidity.equals("high")) {
				System.out.println("Play -> No");
			} else
				System.out.println("Play -> Yes");
		}
	}
}
