package links;

import org.junit.Test;

import static org.junit.Assert.*;

public class URLLinkGeneratorTest {
    @Test
    public void testURLLinkByCityName() {
        assertEquals("api.openweathermap.orf/forecast/2.5/forecast?q=", URLLinkGenerator.generateURLLinkByCityName(""));
    }

    @Test
    public void testURLLinkByNullCityName() {
        assertEquals(null, URLLinkGenerator.generateURLLinkByCityName(null));
    }

    @Test
    public void testURLLinkForCityTallinn() {
        assertEquals("api.openweathermap.orf/forecast/2.5/forecast?q=Tallinn", URLLinkGenerator.generateURLLinkByCityName("Tallinn"));
    }

    @Test
    public void testURLLinkForEmptyCityName() {
        assertEquals("", URLLinkGenerator.generateURLLinkByCityName(""));
    }

    @Test
    public void testURLLinkForCountryNameAndCountryCode() {
        assertEquals("api.openweathermap.orf/forecast/2.5/forecast?q=Tallinn, EE", URLLinkGenerator.generateURLLinkByCityNameAndCountryCode("Tallinn", "EE"));
    }

    @Test
    public void testURLLinkForCityAndCodeNull() {
        assertEquals(null, URLLinkGenerator.generateURLLinkByCityNameAndCountryCode(null, null));
    }


}