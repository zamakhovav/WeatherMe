package file;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public void writeToFile(String content, String path) throws IOException {
        java.io.FileWriter fileWriter = new java.io.FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        bufferedWriter.close();
    }

}
