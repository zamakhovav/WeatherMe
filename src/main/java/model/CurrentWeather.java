package model;


import city.City;
import city.Coordinates;
import exception.WeatherReportNotFoundException;
import utility.Constants;

public class CurrentWeather {
    private City city;
    private double currentTemperature;
    private Constants.Temperature temperatureUnits;

    private CurrentWeather() {}

    public Coordinates cityGeorgaficCoordinate() {
        return city.getCoordinates();
    }

    public double currentWeatherTemperature() {
        return currentTemperature;
    }

    public String getCityName() {
        return city.getCityName();
    }

    public String getCountryCode() {
        return city.getCountryCode();
    }

    public Constants.Temperature getTemperatureUnits() {
        return temperatureUnits;
    }

    public CurrentWeather respondJson(String jSonfile) throws WeatherReportNotFoundException{
        String cityName, countryCode;
        double longtitude, latitude;

        if (city.getCityName() == null) {
            throw new WeatherReportNotFoundException("Wrong city name");
        }
        return new CurrentWeather();
    }
}
