package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.lang.Class.forName;

/**
 * Created by nikasamuell on 09/10/2017.
 */
public class FileWriter {
    Gson gson = new Gson();
    try {
        List<String> lines = Arrays.osList(gson.toJson(report));
        Path file = Path.get(path + "/" +  report.cityName+".txt");
        Files.write(file, Charset,forName("UTF-8"));
    } catch (IOException e) {
        e.printStackTrace();
    }


}
