package weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.IncorrectAPIOutputEaception;
import object.City;
import object.Coordinates;
import request.WeatherRequest;
import utility.CurrentWeatherData;

public class CurrentWeatherFactory {
    //запрос на текующую температуру

    public CurrentWeather generateReportFromJSONAndRequest(String jSonFile, WeatherRequest request) throws IncorrectAPIOutputEaception {
        Gson gson = new GsonBuilder().create();
        CurrentWeatherData APIWeather = gson.fromJson(jSonFile, CurrentWeatherData.class);

        String cityName = getCityNameFromAPIData(APIWeather);
        String countryCode = getCountryCodeFromAPIData(APIWeather);
        double[] coords = getCityCoordinatesFromAPI(APIWeather);
        double currentTemperature = getCurrentTemperatureFromAPI(APIWeather);

        return new CurrentWeather(new City(cityName, countryCode, Coordinates.of(coords[0], coords[1])), currentTemperature, request.getTemperature());
    }

    private String getCityNameFromAPIData(CurrentWeatherData weather) throws IncorrectAPIOutputEaception {
        String cityName = weather.cityName;
        if (cityName == null) {
            throw new IncorrectAPIOutputEaception("Wrong city name");
        }
        return cityName;
    }

    private String getCountryCodeFromAPIData(CurrentWeatherData weather) throws IncorrectAPIOutputEaception {
        String countryCode = (String) weather.data.get("country");
        if (countryCode == null) {
            throw new IncorrectAPIOutputEaception("Wrong country code");
        }
        return countryCode;
    }

    private double[] getCityCoordinatesFromAPI(CurrentWeatherData weather) throws IncorrectAPIOutputEaception {
        double[] coords = new double[2];
        try {
            coords[0] = weather.coordinates.get("lon");
            coords[1] = weather.coordinates.get("lat");

            return coords;
        } catch (NullPointerException e) {
            throw new IncorrectAPIOutputEaception("Invalid coordinates");
        }
    }

    private double getCurrentTemperatureFromAPI(CurrentWeatherData weather) throws IncorrectAPIOutputEaception {
        try {
            return Float.parseFloat(weather.mainData.get("temp").toString());
        } catch (NullPointerException e) {
            throw new IncorrectAPIOutputEaception("Wrong current temperature");
        }

    }
}
