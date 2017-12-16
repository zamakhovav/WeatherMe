package weather;

import object.City;
import object.Coordinates;
import utility.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForecastWeather {
    public static final int DAYS_IN_FORECAST = 3;

    private List<OneDayWeatherForecast> oneDayWeatherForecast;
    private City city;
    private Constants.Temperature temperature;

    public ForecastWeather(City city, List<OneDayWeatherForecast> oneDayWeatherForecast,  Constants.Temperature temperature) {
        this.city = city;
        this.oneDayWeatherForecast = oneDayWeatherForecast;
        this.temperature = temperature;
    }

    public String getCityName() {
        return city.getCityName();
    }

    public String getCountryCode() {
        return city.getCountryCode();
    }

    public Coordinates getCoordinates() {
        return city.getCoordinates();
    }

    public List<OneDayWeatherForecast> getOneDayWeatherForecast() {
        return oneDayWeatherForecast;
    }

    public Constants.Temperature getTemperature() {
        return temperature;
    }
}
