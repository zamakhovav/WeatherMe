package repository;

import exception.WeatherReportNotFoundException;
import forecast.CurrentWeather;
import forecast.WeatherRequest;

public interface Weather {
    CurrentWeather getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException;
}
