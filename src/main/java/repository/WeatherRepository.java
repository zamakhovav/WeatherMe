package repository;

import exception.WeatherReportNotFoundException;
import forecast.CurrentWeather;
import forecast.ForecastWeather;
import forecast.WeatherRequest;

public interface WeatherRepository {
    CurrentWeather getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException;
    ForecastWeather getForecastThreeDays(WeatherRequest request) throws WeatherReportNotFoundException;
}
