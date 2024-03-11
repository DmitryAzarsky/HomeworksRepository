package HW13;

public class Task {
    public Task(int userId, int id, String title, boolean completed) {
        this.completed = completed;
        this.userId = userId;
        this.id = id;
        this.title = title;
    }
    public int userId;
    public int id;
    public String title;
    public boolean completed;

    public boolean isCompleted() {
        return completed;
    }

}
