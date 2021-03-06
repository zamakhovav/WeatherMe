package URLLinks;

import org.junit.Test;

import static org.junit.Assert.*;

public class URLLinkGeneratorTest {
    @Test
    public void testURLLinkByCityName() {
        assertEquals("api.openweathermap.orf/model/2.5/model?q=", URLLinkGenerator.generateURLLinkByCityName(""));
    }

    @Test
    public void testURLLinkByNullCityName() {
        assertEquals(null, URLLinkGenerator.generateURLLinkByCityName(null));
    }

    @Test
    public void testURLLinkForCityTallinn() {
        assertEquals("api.openweathermap.orf/model/2.5/model?q=Tallinn", URLLinkGenerator.generateURLLinkByCityName("Tallinn"));
    }

    @Test
    public void testURLLinkForEmptyCityName() {
        assertEquals("", URLLinkGenerator.generateURLLinkByCityName(""));
    }

    @Test
    public void testURLLinkForCountryNameAndCountryCode() {
        assertEquals("api.openweathermap.orf/model/2.5/model?q=Tallinn, EE", URLLinkGenerator.generateURLLinkByCityNameAndCountryCode("Tallinn", "EE"));
    }

    @Test
    public void testURLLinkForCityAndCodeNull() {
        assertEquals(null, URLLinkGenerator.generateURLLinkByCityNameAndCountryCode(null, null));
    }

    @Test
    public void testURLLinkForEmptyCityAndCountryCode() {
        assertEquals("api.openweathermap.orf/model/2.5/model?q=", URLLinkGenerator.generateURLLinkByCityNameAndCountryCode("", "LV"));
    }

    @Test
    public void testURLLinkForLatAndLonOfTln() {
        assertEquals("api.openweathermap.orf/model/2.5/model?q=", URLLinkGenerator.generateURLLinkByLatitudeAndLongitude(59.4370, 24.7536));
    }
}
