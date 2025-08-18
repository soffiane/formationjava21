package threads;

public class Task implements Runnable{

    private String taskname;

    public Task(String taskname) {
        this.taskname = taskname;
    }

    @Override
    public void run() {
        System.out.println("Task is starting : "+taskname+" by thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(taskname+ " is complete");
    }
}
