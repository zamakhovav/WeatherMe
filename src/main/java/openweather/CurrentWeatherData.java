package openweather;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class CurrentWeatherData {
    @SerializedName("coord")
    public HashMap<String, Float> coordinates;

    @SerializedName("sys")
    public HashMap<String, Object> systemInfo;

    @SerializedName("main")
    public HashMap<String, Object> mainData;

    @SerializedName("name")
    public String cityName;
}
