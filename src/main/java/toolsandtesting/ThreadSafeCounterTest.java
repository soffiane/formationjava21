package toolsandtesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread Safety
 * Race conditions
 * Dead locks
 * Determinism :
 *
 * Test isolation des thread
 * Mocker les dependances
 *
 * Junit
 */
public class ThreadSafeCounterTest {

    @Test
    public void testCounterWithMultipleThreads() throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        Assertions.assertEquals(1000, counter.getCounter(),"Counters don't match");
    }

}
