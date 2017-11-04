package repository;

import utility.Constants;

//Data structure
public class WeatherRequest {
    private String cityName;
    private String cityCode;
    private Constants.Temperature temperature = Constants.Temperature.getTempByDefault();

    private WeatherRequest() {}

    public static WeatherRequest of(String cityName, String cityCode, Constants.Temperature temperature) {
        WeatherRequest request = new WeatherRequest();
        request.cityName = cityName;
        request.cityCode = cityCode;
        request.temperature = temperature;

        return request;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

}
