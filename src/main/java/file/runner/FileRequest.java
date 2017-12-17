package file.runner;

import com.google.gson.annotations.SerializedName;

public class FileRequest {
    @SerializedName("citiesList")
    private String[] cities;
    @SerializedName("temperature")
    private String temperature;

    public String[] getCities() {
        return cities;
    }

    public String getTemperature() {
        return temperature;
    }
}
