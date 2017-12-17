package file.runner;

import weather.CurrentWeather;
import weather.ForecastWeather;

public class FileReport {
    private String cityName;
    private CurrentWeather currentWeather;
    private ForecastWeather forecastWeather;

    public FileReport(String cityName, CurrentWeather currentWeather, ForecastWeather forecastWeather) {
        this.cityName = cityName;
        this.currentWeather = currentWeather;
        this.forecastWeather = forecastWeather;
    }

    public String getCityName() {
        return cityName;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public ForecastWeather getForecastWeather() {
        return forecastWeather;
    }
}
