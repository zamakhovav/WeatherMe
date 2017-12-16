package repository;

import exception.WeatherReportNotFoundException;
import request.WeatherRequest;
import weather.CurrentWeather;
import weather.ForecastWeather;

public interface WeatherRepository {
    CurrentWeather getCurrentWeatherReport(WeatherRequest request) throws WeatherReportNotFoundException;

    ForecastWeather getForecastWeatherReport(WeatherRequest request) throws  WeatherReportNotFoundException;

}
