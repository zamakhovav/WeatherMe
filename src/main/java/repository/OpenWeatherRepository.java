package repository;

import connection.HTTPConnection;
import exception.WeatherReportNotFoundException;
import forecast.CurrentWeather;
import forecast.ForecastWeather;
import forecast.WeatherRequest;

import java.io.IOException;
import java.net.HttpURLConnection;

public class OpenWeatherRepository implements WeatherRepository {
    private static final String FORECAST_API_LINK = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,ee";
    private static final String WEATHER_API_LINK = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,ee";
    private static final String API_KEY = "1097a8485fcf07e8a6e80b8b9e101ac3";

    private static String makeCurrentWeatherRequestLink(WeatherRequest request) {
        String temperatureString = "";
    }

    private static String makeForecastRequestLink(WeatherRequest request) {

    }

    @Override
    public CurrentWeather getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException {
       String connectionLink = ""; //makeCurrentWeatherRequestLink(request); have no idea how to get the link
       HTTPConnection connection;

       try {
           //return new CurrentWeatherReport("Placeholder", new Coordinates(), Constants UNIT.metric, -9999);
           connection = HTTPConnection.makeItGetRequested(connectionLink);
       } catch (Exception e) {
           throw new WeatherReportNotFoundException("getting current weather failed");
       }

       try {
           if (connection.readResponseFromFile().equals(HttpURLConnection.HTTP_NOT_FOUND)) {
               throw new WeatherReportNotFoundException("HTTP not found, invalid data.");
           }
       } catch (IOException e) {
           throw new WeatherReportNotFoundException("Impossible to get data from API");
       }


    }

    @Override
    public ForecastWeather getForecastThreeDays(WeatherRequest request) throws WeatherReportNotFoundException {
        String connectionLink = ""; //makeForecastRequestLink(request); have no idea how to get the link
        HTTPConnection connection;

        try {
            //return new CurrentWeatherReport("Placeholder", new Coordinates(), Constants UNIT.metric, -9999);
            connection = HTTPConnection.makeItGetRequested(connectionLink);
        } catch (Exception e) {
            throw new WeatherReportNotFoundException("getting current weather failed");
        }

        try {
            if (connection.readResponseFromFile().equals(HttpURLConnection.HTTP_NOT_FOUND)) {
                throw new WeatherReportNotFoundException("HTTP not found, invalid data.");
            }
        } catch (IOException e) {
            throw new WeatherReportNotFoundException("Impossible to get data from API");
        }
    }
}
