package data;

import object.City;

import java.time.LocalDateTime;
import java.util.HashMap;

public class WeatherPrediction {
    private HashMap<String, Float> main;
    private City city;

    public HashMap<String, Float> getTemperatures() {
        return main;
    }

    public City getCity() {
        return city;
    }
}
