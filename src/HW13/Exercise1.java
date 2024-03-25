package HW13;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

public class Exercise1 {
    public static void main(String[] args) throws Exception {
        Exercise1 ex1 = new Exercise1();
        ex1.postData();
        ex1.putData();
        ex1.deletePerson();
        ex1.getAllUsers();



        String gaysex = "gaysex";








        ex1.getUserById();
        ex1.getUserByUsername();
    }
    public void getUserByUsername() throws Exception {
        URL url = new URL("https://jsonplaceholder.typicode.com/users?username=\\\"Samantha\\\"");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }
    public void getUserById() throws Exception {
        String url = "https://jsonplaceholder.typicode.com/users/1";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest sendPersonsRequest = HttpRequest.newBuilder(new URI(url)).GET().build();
        HttpResponse<String> getPersonsRequest = httpClient.send(sendPersonsRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET user response code: " + getPersonsRequest.statusCode());
        System.out.println(getPersonsRequest.body());
    }
    public void getAllUsers() throws Exception {
        String url = "https://jsonplaceholder.typicode.com/users";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest sendPersonsRequest = HttpRequest.newBuilder(new URI(url)).GET().build();
        HttpResponse<String> getPersonsRequest = httpClient.send(sendPersonsRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET all users response code: " + getPersonsRequest.statusCode());
        System.out.println(getPersonsRequest.body());
    }
    public void deletePerson() throws Exception {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/2");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        int responseCode = connection.getResponseCode();
        System.out.println("DELETE response code: " + responseCode);
    }
    public void putData() throws Exception {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/10");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(Files.readAllBytes(new File("Exercise1personRenewed.json").toPath()));
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("PUT response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("PUT request not worked");
        }
    }
    public void postData() throws Exception {
        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(Files.readAllBytes(new File("Exercise1person.json").toPath()));
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("POST response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }
}