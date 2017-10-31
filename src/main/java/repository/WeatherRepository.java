package repository;

import city.Coordinates;
import connection.HTTPConnection;
import exception.WeatherReportNotFoundException;
import model.ForecastWeatherReport;
import model.Weather;
import model.WeatherRequest;
import openWeather.OpenWeatherCurrentDTO;
import openWeather.OpenWeatherRepository;
import openWeather.OpenWeatherRequest;

import java.io.IOException;
import java.net.HttpURLConnection;

public class WeatherRepository implements Weather {
    //private static final String FORECAST_API_LINK = "http://api.openweathermap.org/data/2.5/report?q=Tallinn,ee";
    //private static final String WEATHER_API_LINK = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,ee";

    String apiKey = "1097a8485fcf07e8a6e80b8b9e101ac3";
    String weatherCity  = "Tallinn,EE";
    int forecastDays = 3;

    private static String makeCurrentWeatherRequestLink(WeatherRequest request) {
        String temperatureString = "";
    }

    private static String makeForecastRequestLink(WeatherRequest request) {
        String weatherString = "";
        
    }

    @Override
    public WeatherRepository getCurrentWeather(WeatherRequest request) throws WeatherReportNotFoundException {
       String connectionLink = ""; //makeCurrentWeatherRequestLink(request); have no idea how to get the link
       HTTPConnection connection;

       try {
           //return new WeatherRepository("Placeholder", new Coordinates(), Constants UNIT.metric, -9999);
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
    public ForecastWeatherReport getForecastThreeDays(WeatherRequest request) throws WeatherReportNotFoundException {
        String connectionLink = ""; //makeForecastRequestLink(request); have no idea how to get the link
        HTTPConnection connection;

        try {
            //return new WeatherRepository("Placeholder", new Coordinates(), Constants UNIT.metric, -9999);
            connection = HTTPConnection.makeItGetRequested(connectionLink);
        } catch (Exception e) {
            throw new WeatherReportNotFoundException("getting current weather failed, cause" + e.getMessage());
        }

        try {
            if (connection.readResponseFromFile().equals(HttpURLConnection.HTTP_NOT_FOUND)) {
                throw new WeatherReportNotFoundException("HTTP not found, invalid data.");
            }
        } catch (IOException e) {
            throw new WeatherReportNotFoundException("Impossible to get data from API");
        }
    }

    private WeatherRepository getCurrentWeatherFromOpenWeatherMapAPI(WeatherRequest request) throws  IOException {
        OpenWeatherRepository oWRepository = new OpenWeatherRepository();
        OpenWeatherRequest oWRequest = new OpenWeatherRequest(request.cityName, request.countryCode);
        OpenWeatherCurrentDTO oWresponse = oWRepository.getCurrentWeatherReport(oWRequest);
        WeatherRepository currentWeatherReport = convertResponseToCurrentWeatherReport(oWResponse, request);
        return currentWeatherReport;
    }

    private WeatherRepository convertResponseToCurrentWeatherReport(OpenWeatherCurrentDTO oWResponse, WeatherRequest request) {
        Coordinates coordinates = new Coordinates(oWResponse.getCoord().lat, oWResponse.getCoord().lon);
        WeatherRepository currentWeatherReport = new WeatherRepository(oWResponse.getName(), coordinates);
        return currentWeatherReport;
    }

}
