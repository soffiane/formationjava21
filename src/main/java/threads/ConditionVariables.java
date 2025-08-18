package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * classe Condition
 * est associé a un Lock
 * pour ques les threas puissent se mettre en pause (wait) jusqu'a ce qu'on les appelle (notify) selon une condition specifique
 * new Condition()
 * method :
 * await()
 * signal()
 * signalAll()
 * comme wait/notify mais mieux
 */
public class ConditionVariables {
    public static void main(String[] args) throws InterruptedException {
        SharedQueue sharedQueue = new SharedQueue();

        Thread writing = new Thread(() -> {
            for (int i = 0; i <= 6; i++) {
                sharedQueue.produce(i);
            }
        });

        Thread reading = new Thread(() -> {
            for (int i = 0; i <= 6; i++) {
                sharedQueue.consume();
            }
        });

        writing.start();
        reading.start();

        writing.join();
        reading.join();
    }
}

class SharedQueue {
    Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int value) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Queue is full");
                notFull.await();//on attend que la queue se vide pour pouvoir y mettre des truc
            }
            queue.add(value);
            System.out.println(Thread.currentThread().getName() + " produce " + value);
            notEmpty.signal();//on a ajouté une valeur dans la queue
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty");
                notEmpty.await();//on attend que la queue ajoute une valeur pour pouvoir la lire
            }
            System.out.println(Thread.currentThread().getName() + " consume " + queue.poll());
            notFull.signal();//on a lu une valeur
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
