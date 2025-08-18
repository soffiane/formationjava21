package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * des variables que l'on peut modifier sans risque dans un environnement multithread sans synchronized ou des locks
 * thread safe
 */
public class AtomicVariablesExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<6;i++){
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                int newValueOfCounter = atomicInteger.incrementAndGet();
                System.out.println(threadName +" increased the value of "+newValueOfCounter);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Final value of counter "+atomicInteger.get());
    }
}
