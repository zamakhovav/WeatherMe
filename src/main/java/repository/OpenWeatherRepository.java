package repository;

import connection.HTTPConnection;
import connection.UrlLinkGenerator;
import exception.WeatherReportNotFoundException;
import request.WeatherRequest;
import weather.CurrentWeather;
import weather.CurrentWeatherFactory;
import weather.ForecastWeather;
import weather.ForecastWeatherFactory;

import java.io.IOException;
import java.net.HttpURLConnection;



public class OpenWeatherRepository implements WeatherRepository {
    private UrlLinkGenerator linkGenerator;
    private ForecastWeatherFactory forecastWeatherFactory;
    private CurrentWeatherFactory currentWeatherFactory;

    public OpenWeatherRepository() {
        linkGenerator = new UrlLinkGenerator();
        forecastWeatherFactory = new ForecastWeatherFactory();
        currentWeatherFactory = new CurrentWeatherFactory();
    }

    private String getJsonFileFromConnection(HTTPConnection connection) throws WeatherReportNotFoundException {
        try {
            return connection.readFromInputStream();
        } catch (IOException e) {
            throw new WeatherReportNotFoundException("Cannot get openwetherdata from API: " + e.getMessage());
        }
    }

    private HTTPConnection getHTTPConnectionByLink(String conLink) throws WeatherReportNotFoundException {
        try {
            HTTPConnection connection = HTTPConnection.makeConnectionFromURL(conLink);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new WeatherReportNotFoundException("Wrong link!");
            }
            return connection;
        } catch (IOException e) {
            throw new WeatherReportNotFoundException("Cannot get open weather systemInfo from API: " + e.getMessage());
        }
    }

    private String getJSON(String connectionLink) throws WeatherReportNotFoundException {
        HTTPConnection connection = getHTTPConnectionByLink(connectionLink);
        String jSonFile = getJsonFileFromConnection(connection);
        connection.closeConnection();
        return jSonFile;
    }

    @Override
    public CurrentWeather getCurrentWeatherReport(WeatherRequest request) throws WeatherReportNotFoundException {
        try {
            String connectionLink = linkGenerator.createCurrentWeatherRequestUrl(request);
            String jSonFile = getJSON(connectionLink);

            return currentWeatherFactory.generateReportFromJSONAndRequest(jSonFile, request);
        } catch (Exception e) {
            throw new WeatherReportNotFoundException("Getting current weather failed");
        }
    }

    @Override
    public ForecastWeather getForecastWeatherReport(WeatherRequest request) throws WeatherReportNotFoundException {
        try {
            String connectionLink = linkGenerator.createForecastRequestUrlLink(request);
            String jSonFile = getJSON(connectionLink);

            return forecastWeatherFactory.generateReportFromJSONAndRequest(jSonFile, request);
        } catch (Exception e) {
            throw new WeatherReportNotFoundException("Getting forecast weather failed, cause" + e.getMessage());
        }
    }
}
