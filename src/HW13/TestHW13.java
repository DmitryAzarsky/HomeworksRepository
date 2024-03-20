package HW13;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.net.http.*;

public class TestHW13 {
    public static void main(String[] args) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/users";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest sendPersonsRequest = HttpRequest.newBuilder(new URI(url)).GET().build(); // http request
        HttpResponse<String> getPersonsRequest = httpClient.send(sendPersonsRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getPersonsRequest.statusCode());
        System.out.println(getPersonsRequest.body());
        System.out.println(getPersonsRequest.body().getClass());
        System.out.println("Message from new branch!");
    }
}
