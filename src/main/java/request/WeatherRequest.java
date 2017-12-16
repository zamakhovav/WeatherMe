package request;

import utility.Constants;

public class WeatherRequest {
    private String city;
    private String countryCode;
    private Constants.Temperature temperature = Constants.Temperature.getTempByDefault();

    public WeatherRequest(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Constants.Temperature getTemperature() {
        return temperature;
    }
}
