import forecast.CurrentWeather;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.*;

public class WeatherTest {

    @Test
    public void test1() {

    }

    @Test
    public void test2(){
        try {
            String requestURL = "<API REQUEST URL>";
            HttpURLConnection com = CurrentWeather.makeItGetRequested();

            assertEquals(com.getResponseCode(), 200);
        } catch (IOException e) {
            fail("HTTP connection throw error" + e.getLocalizedMessage());
        }
    }

    @Test
    public void testControlHTTPConnection() {

    }

    @Test
    public void testIfWeatherREposirotyRespCityEqualsReqCity() {

    }




}