package HW13;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.*;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        new Exercise2().writeAllUsersComments(1);
    }

    public void writeAllUsersComments(int userId) throws Exception {
        String basePostUrl = "https://jsonplaceholder.typicode.com/users/";
        String pathToSaveFolder = "./FilesForHW13Ex2/";
        int postId = 1;
        int latestPostId = 0;
        while (true) {
            URL urlForPost = new URL(basePostUrl + userId + "/posts?id=" + postId);
            HttpURLConnection connection = (HttpURLConnection) urlForPost.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                if (response.toString().equals("[]") || response.toString().equals("")) {
                    latestPostId = postId - 1;
                    break;
                }
            } else {
                break;
            }
            postId++;

        }
        String allComments = "";
        URL baseCommentUrl = new URL("https://jsonplaceholder.typicode.com/posts/10/comments");
        HttpURLConnection connection = (HttpURLConnection) baseCommentUrl.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            allComments = response.toString();
        }
        List<Comment> listOfComments = new Gson().fromJson(allComments, LinkedList.class);
        for (int i = 0; i < listOfComments.size(); i++) {
            String saveFileName = "user-" + userId + "-post-" + i + "-comments.json";
            FileOutputStream fOs = new FileOutputStream(pathToSaveFolder + saveFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fOs));
            bufferedWriter.write(new GsonBuilder().setPrettyPrinting().create().toJson(listOfComments.get(i)));
            bufferedWriter.close();
        }

    }

}
