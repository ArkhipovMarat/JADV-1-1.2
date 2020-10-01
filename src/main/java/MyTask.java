import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

public class MyTask implements Callable<Integer> {
    private String taskName;
    private int tasksProceedCount;
    private int maxCount;

    public MyTask(String taskName, int operationsCount) {
        this.taskName = taskName;
        this.maxCount = operationsCount;
    }

    public Integer call() {
        for (int i = 0; i < maxCount; i++) {
            System.out.print("Я поток " + Thread.currentThread().getName());
            System.out.print(" Всем привет!!  ");
            tasksProceedCount++;
            System.out.println(" выполняю " + taskName);

            try {
                Thread.sleep(500);
            } catch (InterruptedException | CancellationException e ) {
                return tasksProceedCount;
            }
        }
        return tasksProceedCount;
    }
}
