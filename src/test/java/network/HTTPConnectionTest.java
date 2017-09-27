package network;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.*;

public class HTTPConnectionTest {

    @Test
    public void testConnectionToAPI() {
        HttpURLConnection con = HTTPConnection.makeItGetRequested("api.openweathermap.orf/forecast/2.5/forecast?");
        try {
            assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode());
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testConnectionWithNoLink() {
        HttpURLConnection con = HTTPConnection.makeItGetRequested("");
        try {
            assertEquals(HttpURLConnection.HTTP_NO_CONTENT, con.getResponseCode());
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testConnectionNullLink() {
        HttpURLConnection con = HTTPConnection.makeItGetRequested(null);
        try {
            assertEquals(null, con.getResponseCode());
        } catch (IOException e) {
            fail();
        }
    }

}