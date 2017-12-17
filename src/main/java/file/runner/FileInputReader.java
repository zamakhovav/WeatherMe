package file.runner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileInputReader {
    public final String FILE = "input.txt";

    public String readFromFile() throws IOException {
        StringBuilder stringInput = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader(FILE));

        while (scanner.hasNext()) {
            stringInput.append(scanner.next());
        }
        scanner.close();
        return stringInput.toString();
    }

}
