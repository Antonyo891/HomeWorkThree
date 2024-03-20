package seminar03;

import java.time.LocalDateTime;

public class Task implements Comparable<Task> {
    private static int count_id = 0;
    protected String content_of_the_task;

    protected int id;
    protected LocalDateTime date_of_receipt;
    protected LocalDateTime deadline;

    public Task(String content_of_the_task, LocalDateTime deadline) {
        this.content_of_the_task = content_of_the_task;
        this.date_of_receipt = LocalDateTime.now().withSecond(0).withNano(0);
        this.deadline = deadline;
        this.id = count_id++;
    }

    public Task(String content_of_the_task) {
        this(content_of_the_task,
                LocalDateTime.now().withSecond(0).withNano(0).plusDays(1L));
    }

    public int getId() {
        return this.id;
    }

    public String getContent_of_the_task() {
        return content_of_the_task;
    }

    public LocalDateTime getDate_of_receipt() {
        return date_of_receipt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }


    @Override
    public String toString() {
        return "Task[" +
                " date_of_receipt: " + date_of_receipt + ", " +
                "content_of_the_task: '" + content_of_the_task + '\'' + ", " +
                " deadline: " + deadline +
                ']';
    }

    @Override
    public int compareTo(Task o) {
        return this.getId() - o.getId();
    }
}
