package exception;

public class WeatherReportNotFoundException extends Exception {
    public WeatherReportNotFoundException(String msg) {
        super(msg);
    }

    public WeatherReportNotFoundException() {

    }
}
