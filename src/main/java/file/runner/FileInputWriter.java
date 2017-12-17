package file.runner;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class FileInputWriter {
    private FileWriter fileWriter;

    public FileInputWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeToFile(FileReport file) throws IOException {
        Gson gson = new Gson();
        fileWriter.write(gson.toJson(file));
    }
}
