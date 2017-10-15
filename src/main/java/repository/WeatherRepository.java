package repository;

import exception.WeatherReportNotFoundException;
import report.CurrentWeather;
import report.WeatherRequest;

public interface WeatherRepository {
    CurrentWeather getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException;
    ForecastWeather getForecastThreeDays(WeatherRequest request) throws WeatherReportNotFoundException;
}
