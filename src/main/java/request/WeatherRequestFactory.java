package request;

public class WeatherRequestFactory {
    public WeatherRequest makeRequest(String cityName) {
        WeatherRequest request = new WeatherRequest();
        request.city = cityName;
        return request;
    }

    public WeatherRequest makeRequest(String cityName, String countryCode) {
        WeatherRequest request = new WeatherRequest();
        request.city = cityName;
        request.countryCode = countryCode;
        return request;
    }
}
