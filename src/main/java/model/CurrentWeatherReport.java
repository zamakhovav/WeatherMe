package model;

import city.Coordinates;
import com.google.gson.Gson;

// ITS A DATA STRUCTURE NOT AN OBJECT!
public class CurrentWeatherReport extends WeatherReport {
    public final float tempCurrent;

    public CurrentWeatherReport(String cityName, Coordinates geoCoords, float tempCurrent) {
        super(cityName, geoCoords);
        this.tempCurrent = tempCurrent;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this, CurrentWeatherReport.class);
    }
}
