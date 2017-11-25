package connection;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;

public class HTTPConnectionTest {

   @Test
    public void testConnectionToAPI() throws IOException {
       try {
           HTTPConnection con = HTTPConnection.makeConnectionFromURL("http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1");
           int responseCode = con.getResponseCode();
           assertEquals(HttpURLConnection.HTTP_OK, responseCode);
       } catch (IOException e) {
           e.getMessage();
       }
    }

    @Test(expected = IOException.class)
    public void testConnectionWithNoLink() throws IOException {
       HTTPConnection con = HTTPConnection.makeConnectionFromURL("http://linknofound.com");
       con.getResponseCode();
    }
}