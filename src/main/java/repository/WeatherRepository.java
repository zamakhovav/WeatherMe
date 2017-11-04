package repository;

import exception.WeatherReportNotFoundException;
import model.ForecastWeatherReport;

public interface WeatherRepository {
    WeatherRepository getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException;

    ForecastWeatherReport getForecastThreeDays(WeatherRequest request) throws WeatherReportNotFoundException;
}
