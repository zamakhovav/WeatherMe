package openweather;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class ForecastWeatherData {
    @SerializedName("list")
    public HashMap<String, Object>[] list;

    public OpenWeatherCity city;

}

