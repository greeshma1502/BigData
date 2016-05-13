package onerule;

import java.io.File;
import java.io.FileNotFoundException;

public class HelloOneRule {

	public static void main(String[] args) throws FileNotFoundException {

		ReadFile rfile = new ReadFile();
		UserInput inputdata = new UserInput();
		OneRuleImpl orule = new OneRuleImpl();

		File file = new File("weatherTemp.csv");
		rfile.readFile(file);

		// run algorithm on weather which returns the Deciding Attribute
		System.out.println("After running the algorithm");
		String decidingAttr = orule.ruleOne(rfile.weather);

		System.out
				.println(".....................................................");
		// ask user to input weatherData
		System.out.println("User input data");
		inputdata.inputData();

		// Call method to predict the final output using the Deciding Attribute
		inputdata.predictOutput(decidingAttr);
	}

}
