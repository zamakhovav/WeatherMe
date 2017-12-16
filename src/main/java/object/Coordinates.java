package object;

public class Coordinates {
    private double longitude;
    private double latitude;

    /**
     * City geo location, longitude
     */
    private Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public static Coordinates of(double longitude, double latitude) {
        return new Coordinates(longitude, latitude);
    }

    public String toStringOfLongitude() {
        return Double.toString(longitude);
    }

    public String toStringOfLatitude() {
        return Double.toString(latitude);
    }
}
