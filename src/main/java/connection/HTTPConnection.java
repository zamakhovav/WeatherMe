package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnection {
    HttpURLConnection connection;

    public String readResponseFromFile() throws IOException {
        StringBuilder response = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line + "\n");
        }
        return response.toString();
    }

    public static HTTPConnection makeItGetRequested(String urlLink) throws IOException {
        HTTPConnection httpConnection = new HTTPConnection();
        httpConnection.connection = (HttpURLConnection) new URL(urlLink).openConnection();
        httpConnection.connection.connect();
        return httpConnection;
    }
}
