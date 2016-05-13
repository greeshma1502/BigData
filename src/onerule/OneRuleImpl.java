package onerule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OneRuleImpl {

	// implements one rule algorithm
	public String ruleOne(ArrayList<WeatherData> weather) {

		Map<String, Integer> attributes = new HashMap<String, Integer>();
		Map<String, Integer> attributesErrorCount = new HashMap<String, Integer>();

		ArrayList<String> outlookClasses = new ArrayList<String>();
		ArrayList<String> tempClasses = new ArrayList<String>();
		ArrayList<String> humidityClasses = new ArrayList<String>();
		ArrayList<String> windyClasses = new ArrayList<String>();

		outlookClasses.add("Sunny");
		outlookClasses.add("Overcast");
		outlookClasses.add("Rainy");

		tempClasses.add("hot");
		tempClasses.add("mild");
		tempClasses.add("cool");

		humidityClasses.add("high");
		humidityClasses.add("normal");

		windyClasses.add("TRUE");
		windyClasses.add("FALSE");

		// mapping all the attributes to play
		for (WeatherData weatherData : weather) {
			String keyOutLook = weatherData.getOutlook() + "#"
					+ weatherData.getPlay();
			String keyTemp = weatherData.getTemperature() + "#"
					+ weatherData.getPlay();
			String keyHumidity = weatherData.getHumidity() + "#"
					+ weatherData.getPlay();
			String keyWindy = weatherData.getWindy() + "#"
					+ weatherData.getPlay();

			insertIfAbsent(attributes, keyOutLook);
			insertIfAbsent(attributes, keyTemp);
			insertIfAbsent(attributes, keyHumidity);
			insertIfAbsent(attributes, keyWindy);
		}

		int outlookErr = computeErrorRate(outlookClasses, attributes,
				"Outlook", attributesErrorCount);

		int tempErr = computeErrorRate(tempClasses, attributes, "Temperature",
				attributesErrorCount);

		int humidityErr = computeErrorRate(humidityClasses, attributes,
				"Humidity", attributesErrorCount);

		int windyErr = computeErrorRate(windyClasses, attributes, "Windy",
				attributesErrorCount);

		// calculates minimum error from all error rates
		int minimumErr = Math.min(
				Math.min(Math.min(outlookErr, tempErr), humidityErr), windyErr);
		
		String decidingAttribute = null;

		// returns the attribute which has least error rate
		// if 2 attributes have same error rate, then algorithm chooses the
		// random attribute
		for (String key : attributesErrorCount.keySet()) {
			if (attributesErrorCount.get(key).equals(minimumErr)) {
				decidingAttribute = key;
			}
		}

		System.out.println("Deciding Attribute is: " + decidingAttribute);
		return decidingAttribute;
	}

	// Funcion for inserting key values in the HashMap
	private void insertIfAbsent(Map<String, Integer> weatherMap, String key) {

		if (weatherMap.containsKey(key)) {
			weatherMap.put(key, weatherMap.get(key) + 1);
		} else {
			weatherMap.put(key, 1);
		}
	}

	// Funtion for computing error rate for each set of rules
	private int computeErrorRate(ArrayList<String> attributeMap,
			Map<String, Integer> attributes, String attributeName,
			Map<String, Integer> attributesErrorCount) {
		int totalErr = 0;
		int errorNoCount = 0;
		int errorYesCount = 0;

		for (String tempClass : attributeMap) {
			int count = 0;
			int yesCount = 0;
			int noCount = 0;

			if (attributes.get(tempClass + "#yes") != null) {
				count += attributes.get(tempClass + "#yes");
				yesCount = attributes.get(tempClass + "#yes");
			}
			if (attributes.get(tempClass + "#no") != null) {
				count += attributes.get(tempClass + "#no");
				noCount = attributes.get(tempClass + "#no");
			}

			if (yesCount > noCount) {
				
				errorNoCount += noCount;
			} else {
				
				errorYesCount += yesCount;

			}
		}
		totalErr = errorNoCount + errorYesCount;

		attributesErrorCount.put(attributeName, totalErr);

		return totalErr;

	}

}
