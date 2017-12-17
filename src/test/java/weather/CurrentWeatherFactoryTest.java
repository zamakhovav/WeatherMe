package weather;

import exception.IncorrectAPIOutputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import request.WeatherRequest;
import utility.Constants;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrentWeatherFactoryTest {
    private CurrentWeatherFactory currentWeatherFactory;

    @Before
    public void setUp() {
        currentWeatherFactory = new CurrentWeatherFactory();
    }

    @Test
    public void testGetCurrentWeatherFromJsonFile() {
        String jSon = "{\"coord\":{\"lon\":10.74,\"lat\":59.91}," +
                "\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\"," +
                "\"icon\":\"04n\"}],\"base\":\"stations\"," +
                "\"main\":{\"temp\":264.15,\"pressure\":1013,\"humidity\":92,\"temp_min\":264.15,\"temp_max\":264.15}," +
                "\"wind\":{\"speed\":0.5},\"clouds\":{\"all\":80}," +
                "\"dt\":1513536600,\"sys\":{\"type\":1,\"id\":5325,\"message\":0.0055," +
                "\"country\":\"NO\",\"sunrise\":1513498563,\"sunset\":1513519868}," +
                "\"id\":3143244,\"name\":\"Oslo\",\"cod\":200}";

        WeatherRequest request = mock(WeatherRequest.class);
        when(request.getTemperature()).thenReturn(Constants.Temperature.getTempByDefault());

        try {
            CurrentWeather weather = currentWeatherFactory.generateReportFromJSONAndRequest(jSon, request);

            Assert.assertEquals("NO", weather.getCountryCode());
            Assert.assertEquals(10.74, weather.getCoordinates().getLongitude(), 0.01);
            Assert.assertEquals(59.91, weather.getCoordinates().getLatitude(), 0.01);
        } catch (IncorrectAPIOutputException incorrectAPIOutputException) {
            incorrectAPIOutputException.printStackTrace();
        }


    }

    @Test
    public void testGetCurrentWeatherFromJsonFileWithNegativeLongitude() {
        String jSon = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51}," +
                "\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":" +
                "\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.32,\"pressure\":1012,\"humidity\":" +
                "81,\"temp_min\":279.15,\"temp_max\":281.15},\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80}," +
                "\"clouds\":{\"all\":90},\"dt\":1485789600,\"sys\":{\"type\":1,\"id\":5091,\"message\"" +
                ":0.0103,\"country\":\"GB\",\"sunrise\":1485762037,\"sunset\":1485794875}," +
                "\"id\":2643743,\"name\":\"London\",\"cod\":200}";

        WeatherRequest request = mock(WeatherRequest.class);
        when(request.getTemperature()).thenReturn(Constants.Temperature.getTempByDefault());

        try {
            CurrentWeather currentWeather = currentWeatherFactory.generateReportFromJSONAndRequest(jSon, request);

            Assert.assertEquals("London", currentWeather.getCity());
            Assert.assertEquals("GB", currentWeather.getCountryCode());
            Assert.assertEquals(-0.13, currentWeather.getCoordinates().getLongitude(), 0.01);
            Assert.assertEquals(280.32, currentWeather.getCurrentTemperature(), 0.01);
        } catch (IncorrectAPIOutputException incorrectAPIOutputEaception) {
            incorrectAPIOutputEaception.printStackTrace();
        }
    }

    @Test(expected = IncorrectAPIOutputException.class)
    public void testGetExceptionWhenCityNameIsNotExit() throws IncorrectAPIOutputException {
        String jSon = "{\"coord\":{\"lon\":24.75,\"lat\":59.44}," +
                "\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}]," +
                "\"base\":\"stations\",\"main\":{\"temp\":273.15,\"pressure\":1014," +
                "\"humidity\":100,\"temp_min\":273.15,\"temp_max\":273.15},\"visibility\":10000," +
                "\"wind\":{\"speed\":1.5,\"deg\":280},\"clouds\":{\"all\":90},\"dt\":1513536600," +
                "\"sys\":{\"type\":1,\"id\":5014,\"message\":0.0037," +
                "\"country\":\"EE\",\"sunrise\":1513494936,\"sunset\":1513516767},\"" +
                "id\":590447, \"cod\":200}";

        currentWeatherFactory.generateReportFromJSONAndRequest(jSon, mock(WeatherRequest.class));
    }

    @Test(expected = IncorrectAPIOutputException.class)
    public void testGetExceptionWhenCountryCodeIsNotValid() throws IncorrectAPIOutputException {
        String jSon = "{\"coord\":{\"lon\":24.11,\"lat\":56.95}," +
                "\"weather\":[{\"id\":600,\"main\":\"Snow\"," +
                "\"description\":\"light snow\",\"icon\":\"13n\"}],\"base\":\"stations\"," +
                "\"main\":{\"temp\":273.15,\"pressure\":1017,\"humidity\":100," +
                "\"temp_min\":273.15,\"temp_max\":273.15},\"visibility\":7000," +
                "\"wind\":{\"speed\":2.6,\"deg\":210},\"clouds\":{\"all\":90}," +
                "\"dt\":1513536600,\"sys\":{\"type\":1,\"id\":7368,\"message\":0.0038" +
                ",\"sunrise\":1513493874,\"sunset\":1513518137}," +
                "\"id\":456173,\"name\":\"Riga\",\"cod\":200}";

        currentWeatherFactory.generateReportFromJSONAndRequest(jSon, mock(WeatherRequest.class));
    }
}
