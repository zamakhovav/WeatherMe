package repository;

import model.Weather;
import model.WeatherRequest;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import repository.WeatherRepository;
import utility.Constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CurrentWeatherRepositoryTest {
    private static String exampleCity;
    private static Constants.Temperature exampleTemperature;
    private static WeatherRepository report;
    private static WeatherRequest request;

    @BeforeAll
    // runs only once per class (for expensive shared resources/operations)
    // since the report is only read and not altered, we can initiate one for all the test
    public static void setUpAllTests() {
        // [given]
        request = WeatherRequest.of("Tallinn", "EE" //Constants.COUNTRY_CODE.EE
                , Constants.Temperature.getTempByDefault());
    }

    @AfterAll
    public static void tearDownClass() {
        // runs only per class (for expensive shared resources/operations)
    }

    @BeforeEach
    public void setUpTest() {
        // runs before each test
    }

    @AfterEach
    public void tearDownTest() {
        // runs before each test
    }

    @Test
    public void testIfWeatherRepositoryRespCityEqualsReqCity() {
        try {
            // [given]
            Weather weatherRepository = new WeatherRepository();
            // [when]
            WeatherRepository report = weatherRepository.getCurrentWeather(request);
            // [then]
            assertEquals(request.getCityName(), report.cityName);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherRepoResponseCityCoordinatesAreValid() {
        try {
            // [given]
            Weather weatherRepo = new WeatherRepository();
            // [when]
            WeatherRepository report = weatherRepo.getCurrentWeather(request);
            // [then]
            assertEquals(request.getCityCode(), report.cityCode);
        } catch (Exception e) {
            fail("Failre cause: " + e.getMessage());
        }
    }


}
