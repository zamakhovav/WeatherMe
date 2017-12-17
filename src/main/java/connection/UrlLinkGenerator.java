package connection;

import request.WeatherRequest;

public class UrlLinkGenerator {
    private static final String FORECAST_API_LINK = "http://api.openweathermap.org/data/2.5/forecast?";
    private static final String CURRENT_WEATHER_API_LINK = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String API_KEY = "e784972ab6f8b73f7d36ccac2b73fbff";

    public String createCurrentWeatherRequestUrl(WeatherRequest request) {
        return CURRENT_WEATHER_API_LINK + "q=" + request.city + "&appid=" + API_KEY;
    }

    public String createForecastRequestUrlLink(WeatherRequest request) {
        return FORECAST_API_LINK + "q=" + request.city + "&appid=" + API_KEY;
    }
}
