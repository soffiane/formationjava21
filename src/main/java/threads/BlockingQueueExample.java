package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        Thread consume = new Thread(() -> consume(queue));
        Thread produce = new Thread(() -> produce(queue));

        consume.start();
        produce.start();

        consume.join();
        produce.join();

    }

    public static void produce(BlockingQueue<Integer> queue) {
        for (int i = 0; i <= 5; i++) {
            try {
                queue.put(i);//bloque si la queue est pleine
                System.out.println("Produced " + i);

                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void consume(BlockingQueue<Integer> queue) {
        for (int i = 0; i <= 5; i++) {
            try {
                Integer poll = queue.take();//bloque si la queue est vide
                System.out.println("Consumed " + poll);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
