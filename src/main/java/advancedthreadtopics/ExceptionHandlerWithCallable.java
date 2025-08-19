package advancedthreadtopics;

import java.util.concurrent.*;

public class ExceptionHandlerWithCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName() + " task started");
            double value = Math.random();
            System.out.println("Generated number by " + Thread.currentThread().getName() + " is " + value);
            if (value > 0.5) {
                throw new RuntimeException("Simulation error");
            }
            Thread.sleep(1000);
            return Thread.currentThread().getName() + " task completed ";
        };

        Future<String> future = executorService.submit(task);//on soumet la tache pour execution

        String result = null;
        try {
            result = future.get();
            System.out.println("result is "+result);
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
            System.out.println("Task interrupted");
        } catch (ExecutionException e) {
            System.out.println("Task failed with exception "+e.getCause().getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
