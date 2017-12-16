package weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.IncorrectAPIOutputEaception;

import object.City;
import object.Coordinates;
import request.WeatherRequest;
import utility.ForecastWeatherData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForecastWeatherFactory {
    // запрос на прогноз погоды за 3 дня

    public ForecastWeather generateReportFromJSONAndRequest(String jsonFile, WeatherRequest request) throws IncorrectAPIOutputEaception {
        Gson gson = new GsonBuilder().create();
        ForecastWeatherData forecastWeather = gson.fromJson(jsonFile, ForecastWeatherData.class);

        String cityName = getCityNameFromAPIData(forecastWeather);
        String countryCode = getCountryCodeFromAPIData(forecastWeather);
        double[] coordinates = getCityCoordinatesFromAPI(forecastWeather);
        List<OneDayWeatherForecast> date = getForecastOneDayTemperatureFromAPI(forecastWeather);

        return new ForecastWeather(new City(cityName, countryCode, Coordinates.of(coordinates[0], coordinates[1])), date, request.getTemperature());
    }

    private String getCityNameFromAPIData(ForecastWeatherData weather) throws IncorrectAPIOutputEaception {
        String cityName = weather.city.getCityName();
        if (cityName == null) {
            throw new IncorrectAPIOutputEaception("Wrong city name");
        }
        return cityName;
    }

    private String getCountryCodeFromAPIData(ForecastWeatherData weather) throws IncorrectAPIOutputEaception {
        String countryCode = weather.city.getCountryCode();
        if (countryCode == null) {
            throw new IncorrectAPIOutputEaception("Wrong country code");
        }
        return countryCode;
    }

    private double[] getCityCoordinatesFromAPI(ForecastWeatherData weather) throws IncorrectAPIOutputEaception {
        double[] coords = new double[2];
        try {
            coords[0] = weather.city.getCoordinates().getLongitude();
            coords[1] = weather.city.getCoordinates().getLatitude();

            return coords;
        } catch (NullPointerException e) {
            throw new IncorrectAPIOutputEaception("Invalid coordinates");
        }
    }

    private List<OneDayWeatherForecast> getForecastOneDayTemperatureFromAPI(ForecastWeatherData weather) throws IncorrectAPIOutputEaception {
        List<OneDayWeatherForecast> forecasts = new ArrayList<>();
        LocalDate currentDay = null;
        LocalDate today = LocalDate.now();
        OneDayWeatherForecast oneDayWeather = null;

        for (HashMap<String, Object> list : weather.list) {
            String dateTime = (String) list.get("dt_txt");
            LocalDate localDate = LocalDate.parse(dateTime, DateTimeFormatter.ofPattern("yy-mm-dd hh:mm:ss"));

            if (localDate.getYear() == today.getYear()) {
                continue;
            }

            if (currentDay == null || localDate.getDayOfYear() - currentDay.getDayOfYear() >= 1) {
                currentDay = localDate;

                if (oneDayWeather != null) {
                    forecasts.add(oneDayWeather);

                    if (forecasts.size() >= ForecastWeather.DAYS_IN_FORECAST) {
                        break;
                    }
                }

                oneDayWeather = new OneDayWeatherForecast();
                oneDayWeather.currentDateTime = currentDay;
            }

            HashMap<String, Double> temperatures = (HashMap<String, Double>) list.get("main");
            double minimumTemperature = temperatures.get("temp_min");
            double maximumTemperature = temperatures.get("temp_max");

            oneDayWeather.minTemperature = Math.min(minimumTemperature, oneDayWeather.minTemperature);
            oneDayWeather.maxTemperature = Math.max(maximumTemperature, oneDayWeather.maxTemperature);
        }
        return forecasts;
    }
}
