package file.runner;

import java.util.Scanner;

public class ConsoleInput {
    // @SerializedName("min_temp") для gson
    //консоль нужен для запроса, в котором у пользователя спрашивают название города и затем код страны
    Scanner scanner = new Scanner(System.in);

    void askInputName() {
        System.out.println("Enter city name (or enter Not): ");
        if (!scanner.nextLine().equals("Not")) {
            scanner.nextLine();
        }
        scanner.close();
    }
}
