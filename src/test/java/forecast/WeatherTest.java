package forecast;

import city.City;
import org.junit.Test;

import static org.junit.Assert.*;


public class WeatherTest {

    @Test
    public void testCityGeoCoordinates() {
        String jSon = "{\"city\":{\"id\":1851632,\"name\":\"Shuzenji\",\n" +
                "\"coord\":{\"lon\":138.933334,\"lat\":34.966671},\n" +
                "\"country\":\"JP\",\n" +
                "\"cod\":\"200\",\n" +
                "\"message\":0.0045,\n" +
                "\"cnt\":38,\n" +
                "\"list\":[{\n" +
                "        \"dt\":1406106000,\n" +
                "        \"main\":{\n" +
                "            \"temp\":298.77,\n" +
                "            \"temp_min\":298.77,\n" +
                "            \"temp_max\":298.774,\n" +
                "            \"pressure\":1005.93,\n" +
                "            \"sea_level\":1018.18,\n" +
                "            \"grnd_level\":1005.93,\n" +
                "            \"humidity\":87\n" +
                "            \"temp_kf\":0.26},\n" +
                "        \"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\n" +
                "        \"clouds\":{\"all\":88},\n" +
                "        \"wind\":{\"speed\":5.71,\"deg\":229.501},\n" +
                "        \"sys\":{\"pod\":\"d\"},\n" +
                "        \"dt_txt\":\"2014-07-23 09:00:00\"}\n" +
                "        ]}";

        Weather cityWeather = Weather.respondJson(jSon);


        assertEquals(298, cityWeather.maxTemperature());
        assertEquals(290, cityWeather.minTemperature());
        assertEquals("Overcast clouds", cityWeather.weatherDescription());
        assertEquals(294, cityWeather.forecastDataOf3hours());
        assertEquals(289, cityWeather.currentWeatherTemperature());
    }
}
