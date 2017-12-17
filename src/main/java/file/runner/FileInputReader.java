package file.runner;

import com.google.gson.Gson;
import exception.IncorrectAPIOutputException;
import file.FileReader;


import java.io.IOException;

public class FileInputReader {
    private FileReader reader;

    public FileInputReader(FileReader reader) {
        this.reader = reader;
    }

    public FileRequest readFromFile(String path) throws IOException {
        Gson gson = new Gson();
        try {
            return gson.fromJson(reader.readFromFile(path), FileRequest.class);
        } catch (IOException e) {
            throw new IncorrectAPIOutputException();
        }
    }

}
