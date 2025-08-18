package threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Collections thread safe ne necessitant pas de gerer manuellement des threads et la synchronisation
 * ConcurrentHashMap, CopyOnWriteArrayList, ConcurrentLinkedQueue
 * mais aussi : ConcurrentSkipListMap, ConcurrentSkipListSet, ArrayBlockingQueue, ProirityBlockingQueue, LinkingBlockingQueue
 */
public class ConcurrentCollectionsExample {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String> taskResult = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0;i<6;i++){
            String taskname = " Task "+i;
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+" is executing "+taskname);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                taskResult.put(taskname,"Completed by "+threadName);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        taskResult.forEach((task,result) -> System.out.println("task "+task+" result "+result));
    }
}
