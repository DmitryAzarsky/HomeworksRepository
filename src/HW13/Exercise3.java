package HW13;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.google.gson.reflect.TypeToken;

import com.google.gson.*;
public class Exercise3 {
    String basicUsersUrl = "https://jsonplaceholder.typicode.com/users/";
    public static void main(String[] args) throws Exception{
        new Exercise3().printAllOpenedTasks(1);
    }
    public void printAllOpenedTasks(int userId) throws Exception{
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI(basicUsersUrl + userId + "/todos")).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        List<Task> taskList =  new Gson().fromJson(response.body(), new TypeToken<List<Task>>() {}.getType());
        Stream<Task> taskStream = taskList.stream();
        taskList = taskStream.distinct().filter(task -> !task.isCompleted()).collect(Collectors.toList());
//        Stream<Task> taskStream = taskList.stream().map(element -> (Task)element);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(taskList));

    }
}
