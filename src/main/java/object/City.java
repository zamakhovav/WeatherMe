package object;

public class City {
    private String cityName;
    private String countryCode;
    private Coordinates coordinates;

    public City(String cityName, String countryCode, Coordinates coordinates) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.coordinates = coordinates;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
