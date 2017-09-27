package URLLinks;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by nikasamuell on 26/09/2017.
 */
public class URLLinkGenerator {
    public static final String API_URL ="api.openweathermap.orf/forecast/2.5/forecast?";
    public static final String API_KEY = "1097a8485fcf07e8a6e80b8b9e101ac3";

    public static boolean isCountryCodeValid(String codeCountry) {
        return Arrays.asList(Locale.getISOCountries()).contains(codeCountry.toUpperCase());
    }

    public static String generateURLLinkByCityName(String cityName) {
        return null;
    }

    public static String generateURLLinkByCityNameAndCountryCode(String cityName, String zipCode) {
        return null;
    }

    public static String generateURLLinkByLatitudeAndLongitude(double latitude, double longitude) {
        return null;
    }
}
