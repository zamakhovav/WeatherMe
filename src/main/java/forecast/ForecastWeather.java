package forecast;

import java.util.Date;

/**
 * The weather forecast for a specific day.
 */
public class ForecastWeather {
    /**
     * Day of the week to which this forecast applies.
     */
    private WeekDay day;

    /**
     * The date to which this forecast applies.
     */
    private Date date;

    /**
     * The forecasted low temperature for this day.
     */
    private int low;

    /**
     * The forecasted high temperature for this day.
     */
    private int high;

    /**
     * A textual description of conditions.
     */
    private String text;

    /**
     * The condition code for this forecast.
     */
    private int code;

    public ForecastWeather

    {

    }

    public ForecastWeather(WeekDay day, Date date, int low, int high, String text, int code) {
        this.day = day;
        this.date = date;
        this.low = low;
        this.high = high;
        this.text = text;
        this.code = code;
    }

    public WeekDay getDay() {
        return day;
    }

    public Date getDate() {
        return date;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }
}
