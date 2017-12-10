package file.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    File input = new File("/Users/nikasamuell/IdeaProjects/WeatherMe2/src/main/java/file/input.txt");
    File output = new File("/Users/nikasamuell/IdeaProjects/WeatherMe2/src/main/java/file/output.txt");

    private List<String> listOfCities = new ArrayList<>();
    private String cityName;

    public void readFromFile() throws IOException {
        String fileName = "/Users/nikasamuell/IdeaProjects/WeatherMe2/src/main/java/file/runner/input.txt";
        String line;

        try {
            java.io.FileReader fileReader = new java.io.FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split(":");
                listOfCities.add(splittedLine[1]);
                cityName = splittedLine[1];
            }
        }catch (FileNotFoundException exeption) {
            System.out.println("Cannot open the file");
        }
    }

}
