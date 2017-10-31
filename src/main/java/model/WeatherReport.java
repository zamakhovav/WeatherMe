package model;

import city.Coordinates;

// DATA STRUCTURE
// DTO
public class WeatherReport {
    public final String cityName;
    public final Coordinates geoCoordinates;

    public WeatherReport(String cityName, Coordinates geoCoordinates) {
        this.cityName = cityName;
        this.geoCoordinates = geoCoordinates;
    }
}
