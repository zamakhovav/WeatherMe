package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    //private String fileName = "/Users/nikasamuell/IdeaProjects/WeatherMe2/src/main/java/file/input.txt";

    public String readFromFile(String path) throws IOException {
        String line;
        java.io.FileReader fileReader = new java.io.FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder content = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        bufferedReader.close();
        return content.toString();
    }
}
