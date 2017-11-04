package exception;

import java.io.IOException;

public class WeatherReportNotFoundException extends IOException {
    public WeatherReportNotFoundException(String msg) {
        super(msg);
    }

    public WeatherReportNotFoundException() {

    }
}
