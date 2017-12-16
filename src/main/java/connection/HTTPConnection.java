package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnection {
    HttpURLConnection connection;

    public String readFromInputStream() throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;

        while ((line = reader.readLine()) != null) {
            builder.append(line + "\n");
        }

        reader.close();

        return builder.toString();
    }

    public int getResponseCode() throws IOException {
        return connection.getResponseCode();
    }

    public void closeConnection() {
        connection.disconnect();
    }

    public static HTTPConnection makeConnectionFromURL(String urlLink) throws IOException {
        HTTPConnection httpConnection = new HTTPConnection();
        httpConnection.connection = (HttpURLConnection) new URL(urlLink).openConnection(); // get object of HttpUrlConnection
        httpConnection.connection.connect();
        return httpConnection;
    }
}
