package console.runner;

import request.WeatherRequest;

import java.util.Scanner;

public class ConsoleInput {

    Scanner scanner = new Scanner(System.in);

    private String askInputName(String inputQuestion) {
        System.out.println("Please enter (for closing enter Not): " + inputQuestion);
        if (scanner.nextLine().equals("Not")) {
            scanner.close();
        }
        return scanner.nextLine();
    }

    public WeatherRequest  getInputNameFromConsole() {
        return new WeatherRequest(askInputName("city name"), askInputName("country code"));
    }
}
