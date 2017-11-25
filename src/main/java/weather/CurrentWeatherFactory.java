package weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.IncorrectAPIOutputEaception;
import object.City;
import object.Coordinates;
import request.WeatherRequest;

public class CurrentWeatherFactory {

    public static CurrentWeather generateReportFromJSONAndRequest(String jSonFile, WeatherRequest request) throws IncorrectAPIOutputEaception {
        Gson gson = new GsonBuilder().create();
        CurrentWeather weather = gson.fromJson(jSonFile, CurrentWeather.class);

        String cityName = getCityNameFromAPI(weather);
        String countryCode = getCountryCodeFromAPI(weather);
        double[] coords = getCityCoordinatesFromAPI(weather);
        double currentTemperature = getCurrentTemperatureFromAPI(weather);

        return new CurrentWeather(new City(cityName, countryCode, Coordinates.of(coords[0], coords[1])), currentTemperature, request.getTemperature());
    }

    private static String getCityNameFromAPI(CurrentWeather weather) throws IncorrectAPIOutputEaception {
        String cityName = weather.getCity();
        if (cityName == null) {
            throw new IncorrectAPIOutputEaception("Wrong city name");
        }

        return cityName;
    }

    private static String getCountryCodeFromAPI(CurrentWeather weather) throws IncorrectAPIOutputEaception {
        String countryCode = weather.getCountryCode();

        if (countryCode == null) {
            throw new IncorrectAPIOutputEaception("Wrong country code");
        }

        return countryCode;
    }

    private static double[] getCityCoordinatesFromAPI(CurrentWeather weather) throws IncorrectAPIOutputEaception {
        double[] coords = new double[2];
        try {
            coords[0] = weather.getCoordinates().getLongitude();
            coords[1] = weather.getCoordinates().getLatitude();

            return coords;
        } catch (NullPointerException e) {
            throw new IncorrectAPIOutputEaception("Invalid coordinates");
        }

    }

    private static double getCurrentTemperatureFromAPI(CurrentWeather weather) throws IncorrectAPIOutputEaception {
        try {
            return weather.getCurrentTemperature();
        } catch (NullPointerException e) {
            throw new IncorrectAPIOutputEaception("Wrong current temperature");
        }

    }

}
