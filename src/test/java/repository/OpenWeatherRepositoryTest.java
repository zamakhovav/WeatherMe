package repository;

import exception.IncorrectAPIOutputEaception;
import exception.WeatherReportNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import request.WeatherRequest;
import request.WeatherRequestFactory;
import weather.CurrentWeather;
import weather.ForecastWeather;

public class OpenWeatherRepositoryTest {
    private WeatherRepository repository;
    private WeatherRequestFactory requestFactory;

    @Before
    public void setUp() {
        repository = new OpenWeatherRepository();
        requestFactory = new WeatherRequestFactory();
    }

    @Test
    public void testGetCurrentWeatherByRequestAsCityName() throws WeatherReportNotFoundException {
        WeatherRequest request = requestFactory.makeRequest("Tallinn");
        CurrentWeather currentWeather = repository.getCurrentWeatherReport(request);

        Assert.assertEquals(request.getCity(), currentWeather.getCity());
    }

    @Test
    public void testGetCurrentWeatherByRequestAsCityNameAndCountryCode() throws WeatherReportNotFoundException {
        WeatherRequest request = requestFactory.makeRequest("London", "GB");
        CurrentWeather currentWeather = repository.getCurrentWeatherReport(request);

        Assert.assertEquals(request.getCity(), currentWeather.getCity());
        Assert.assertEquals(request.getCountryCode(), currentWeather.getCountryCode());
    }

    @Test
    public void test() throws WeatherReportNotFoundException {
        WeatherRequest request = requestFactory.makeRequest("Tallinn");
        ForecastWeather forecastWeather = repository.getForecastWeatherReport(request);

        Assert.assertEquals(request.getCity(), forecastWeather.getCityName());
    }

    @Test
    public void testGetForecastWeatherByRequestAsCityAndCountryCode() throws WeatherReportNotFoundException {
        WeatherRequest request = requestFactory.makeRequest("Berlin", "DE");
        ForecastWeather forecastWeather = repository.getForecastWeatherReport(request);

        Assert.assertEquals(request.countryCode, forecastWeather.getCountryCode());
        Assert.assertEquals(request.getCountryCode(), forecastWeather.getCountryCode());
    }

    @Test
    public void testGetCurrentWeatherTemperatureUnits() throws WeatherReportNotFoundException {
        WeatherRequest request =requestFactory.makeRequest("Tallinn");
        CurrentWeather currentWeather = repository.getCurrentWeatherReport(request);

        Assert.assertEquals(request.getTemperature(), currentWeather.getTemperatureUnits());

    }

    @Test(expected = WeatherReportNotFoundException.class)
    public void testGetCurrentWeatherWithRandomCityName() throws WeatherReportNotFoundException {
        WeatherRequest request = requestFactory.makeRequest("RandomText");

        repository.getCurrentWeatherReport(request);
    }

    @Test(expected = WeatherReportNotFoundException.class)
    public void testGetCurrentWeatherWithRandomCountryCode() throws WeatherReportNotFoundException {
        WeatherRequest request = requestFactory.makeRequest("RandomText","5654758");

        repository.getCurrentWeatherReport(request);
    }
}
