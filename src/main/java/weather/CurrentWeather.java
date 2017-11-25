package weather;


import object.City;
import object.Coordinates;
import exception.WeatherReportNotFoundException;
import utility.Constants;

public class CurrentWeather {
    private City city;
    private double currentTemperature;
    private Constants.Temperature temperatureUnits;

    public CurrentWeather(City city, double currentTemperature, Constants.Temperature temperatureUnits) {
        this.city = city;
        this.currentTemperature = currentTemperature;
        this.temperatureUnits = temperatureUnits;
    }

    public String getCity() {
        return city.getCityName();
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public String getCountryCode() {
        return city.getCountryCode();
    }

    public Coordinates getCoordinates() {
        return city.getCoordinates();
    }

    public Constants.Temperature getTemperatureUnits() {
        return temperatureUnits;
    }

    @Override
    public String toString() {
        return String.format("City: %s [%s]\n Coordinates: %s\n Temperature: %s",
                getCity(), getCountryCode(), city.getCoordinates(), getCurrentTemperature());
    }
}
