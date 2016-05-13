package onerule;

public class WeatherData {

	private String outlook;
	private String temperature;
	private String humidity;
	private String windy;
	private String play;

	public WeatherData(String outlook, String temperature, String humidity,
			String windy, String play) {
		this.outlook = outlook;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windy = windy;
		this.play = play;

	}

	public WeatherData() {
		super();
	}

	@Override
	public String toString() {
		String str = getOutlook() + " " + getTemperature() + " "
				+ getHumidity() + " " + getWindy() + " " + getPlay();
		return str;
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindy() {
		return windy;
	}

	public void setWindy(String windy) {
		this.windy = windy;
	}

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

}
