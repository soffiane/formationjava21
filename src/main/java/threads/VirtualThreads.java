package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * En reponse aux limitations des threads OS, java devoile les threads virtuels.
 * Beaucoup plus léger, moins de conso memoire, stocké dans la heap
 * Chaque VirtualThread est assigné a un thread OS grace au planificateur JDK (ForkJoinPool)
 * Quand le thread virtuel monte dans un ThreadOs, il est mounted (comme une VM)
 * En attente ils sont unmounted
 */
public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread helloWOrld = Thread.ofVirtual().start(() -> System.out.println("Hello WOrld"));
        helloWOrld.join();
        Thread.Builder.OfVirtual ofVirtual = Thread.ofVirtual().name("MonVirtualThread");
        Runnable task = () -> {
            System.out.println("running....");
        };
        Thread t = ofVirtual.start(task);
        System.out.println("Thread name : " + t.getName());
        t.join();

        // Let's conjure up our own magical virtual thread pool
        ExecutorService threadPool = Executors.newVirtualThreadPerTaskExecutor();
        // Now, let's add some tasks to accomplish
        for (int i = 0; i < 10; i++) {
            threadPool.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task accomplished by " + threadName);
            });
        } // Don't forget to dismiss the pool once tasks are done!
        threadPool.shutdown();
    }
}
