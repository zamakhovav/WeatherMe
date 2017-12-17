package request;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utility.Constants;

public class WeatherRequestTest {
    private WeatherRequestFactory weatherRequest;

    @Before
    public void setUp() {
        weatherRequest = new WeatherRequestFactory();
    }

    @Test
    public void testMakeRequestForCertainCity() {
        WeatherRequest request = weatherRequest.makeRequest("Tallinn");
        Assert.assertEquals("Tallinn", request.getCity());
    }

    @Test
    public void testMakeRequestWhenTemperatureIsNotDetermined() {
        WeatherRequest request = weatherRequest.makeRequest("London", "UK");
        Assert.assertEquals(Constants.Temperature.getTempByDefault(), request.getTemperature());
    }

    @Test
    public void testMakeRequestForCertainCountryCode() {
        WeatherRequest request = weatherRequest.makeRequest("Helsinki", "FI");
        Assert.assertEquals("FI", request.getCountryCode());
    }

    @Test
    public void test2() {
        WeatherRequest request = weatherRequest.makeRequest("Paris", "FR", Constants.Temperature.METRIC);
        Assert.assertEquals(Constants.Temperature.METRIC, request.getTemperature());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test() throws IllegalArgumentException {
        weatherRequest.makeRequest("Riga", "LVV");

    }
}
