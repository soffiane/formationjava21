package advancedthreadtopics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Producer Consumer pattern :
 * 2 entités : Produceur qui ajoute des taches ou des données dans un buffer
 * Consumer : traiter les données du buffer
 * Decouplage de la creation et du traitement des taches, concurrence
 * Requiert une bonne synchronisation pour eviter les deadlock ou les dirty read/write
 * Performance dependant de la taille du buffer et la vitesses des deux entités
 */
public class ProducerConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

        try {
            consumer.join();
            producer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                int value = (int) (Math.random() * 100);
                queue.put(value);
                System.out.println("Produced : " + value);
                Thread.sleep(500);
            }
            queue.put(-1);
        } catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName());
        }

    }
}

class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                if(value == -1){
                    break;
                }
                System.out.println("Consumed : " + value);
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
