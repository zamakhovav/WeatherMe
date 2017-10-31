package model;

import exception.WeatherReportNotFoundException;
import repository.WeatherRepository;

public interface Weather {
    WeatherRepository getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException;

    ForecastWeatherReport getForecastThreeDays(WeatherRequest request) throws WeatherReportNotFoundException;
}
