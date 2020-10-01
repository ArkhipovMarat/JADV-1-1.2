import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int taskTime = 5;

        Callable<Integer> task1 = new MyTask("задача №1", 2);
        Callable<Integer> task2 = new MyTask("задача №2", 3);
        Callable<Integer> task3 = new MyTask("задача №3", 5);
        Callable<Integer> task4 = new MyTask("задача №4", 10);

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Integer>> tasks = Arrays.asList(task1, task2, task3, task4);

        List<Future<Integer>> results = threadPool.invokeAll(tasks, taskTime, TimeUnit.SECONDS);
        threadPool.shutdown();

        System.out.println("-------------------");

        for (Future<Integer> result : results) {
            if (result.isDone() & !result.isCancelled()) {
                System.out.println("задача выполнена полностью, результат: " + result.get());
            }
        }
    }
}
