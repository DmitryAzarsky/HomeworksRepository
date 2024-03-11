package HW13;

public class Comment {
    public Comment(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.body = body;
        this.email = email;
        this.name = name;
        this.id = id;
    }
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;
}
