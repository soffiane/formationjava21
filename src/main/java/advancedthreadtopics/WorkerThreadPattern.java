package advancedthreadtopics;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * * Worker Thread Pattern :
 *  * Un pool de thread de taille fixe est crée les taches sont queued et les threads sont traités de maniere sequentielles
 *  * Efficace car les thread sont reutilisé, pas d'overhead a cause du cycle creation/destruction de threads
 *  * Inconvenient :
 *  * les taches doivent attendre pour avoir un thread dispo
 *  * il faut implementer la priorité ou fairness des threads ce qui ajoute de la complexité
 */
public class WorkerThreadPattern {
    public static void main(String[] args) {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        int poolSize = 3;
        Worker[] workers = new Worker[poolSize];

        for(int i =0; i<poolSize;i++){
            workers[i] = new Worker(taskQueue);
            workers[i].start();
        }

        //adding tasks to the queue
        for(int i = 1;i<=10;i++){
            taskQueue.add(new Task(i));
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //stop workers after task completion
        for(Worker worker : workers){
            worker.interrupt();
        }
    }

}

class Task implements Runnable{

    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " processing "+taskId);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+ " processed "+taskId);
    }
}

class Worker extends Thread {
    private final BlockingQueue<Runnable> taskQueue;

    public Worker(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Runnable task = taskQueue.take();
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
