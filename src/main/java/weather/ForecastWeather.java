package weather;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForecastWeather {
    private List<Integer> currentDayWeather = new ArrayList<Integer>();

    private List<Integer> firstDayWeather = new ArrayList<Integer>();
    private List<Integer> secondDayWeather = new ArrayList<Integer>();
    private List<Integer> thirdDayWeather = new ArrayList<Integer>();

    private List<List<Integer>> eachDayTemperatures = Arrays.asList(currentDayWeather, firstDayWeather, secondDayWeather, thirdDayWeather);

    public List<Integer> getCurrentDayWeather() {
        return currentDayWeather;
    }

    public List<Integer> getFirstDayWeather() {
        return firstDayWeather;
    }

    public List<Integer> getSecondDayWeather() {
        return secondDayWeather;
    }

    public List<Integer> getThirdDayWeather() {
        return thirdDayWeather;
    }
}
