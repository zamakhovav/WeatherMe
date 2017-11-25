package repository;

import object.City;

import object.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class CityTest {
    private City city;

    @Before
    public void setUp() throws Exception {
        city = new City("Tallinn", "EE", Coordinates.of(59.44, 24.75));
    }

    @Test
    public void testRequestToLatitude() {
        try {
            assertEquals("24.75", city.getCoordinates().toStringOfLatitude());
        } catch (Exception e) {
            fail("Failure was caused by " + e.getMessage());
        }
    }

    @Test
    public void testRequestToLongitude() {
        try {
            assertEquals("59.44", city.getCoordinates().toStringOfLongitude());
        } catch (Exception e) {
            fail("Failure was caused by " + e.getMessage());
        }
    }

    @Test
    public void testRequestToCity() {
        try {
            assertEquals("Tallinn", city.getCityName());
        } catch (Exception e) {
            fail("Failure was caused by " + e.getMessage());
        }
    }

    @Test
    public void testRequestToCityCode() {
        try {
            assertEquals("EE", city.getCountryCode());
        } catch (Exception e) {
            fail("Failure was caused by " + e.getMessage());
        }
    }
}
