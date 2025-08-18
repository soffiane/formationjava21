package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class LocksAndConditions {
    public static void main(String[] args) throws InterruptedException {
        SharedBufferWithLock sharedBufferWithLock = new SharedBufferWithLock();
        Thread producer = new Thread(() -> {
            for(int i =0;i<5;i++){
                sharedBufferWithLock.produce(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Producer");

        Thread consumer = new Thread(() -> {
            for(int i =0;i<5;i++){
                sharedBufferWithLock.consume();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class SharedBufferWithLock {
    private int data;
    private boolean hasData = false;
    // lock the buffer when is accessed
    private Lock lock = new ReentrantLock();
    //ressemble au mecanisme de wait/notify
    private final Condition condition = lock.newCondition();

    //producer
    public void produce(int value) {
        //on verouille la methode quand on y accede
        lock.lock();
        try {
            while (hasData) {

                condition.await();//equivalent de wait()

            }
            data = value;
            System.out.println(Thread.currentThread().getName() + " produced " + data);
            hasData = true;
            condition.signal();//equivalent de notify
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();//dans un finally pour eviter un deadlock
        }

    }

    public synchronized void consume() {
        lock.lock();
        try {
            while (!hasData) {
                condition.await();//equivalent de wait()
            }
            System.out.println(Thread.currentThread().getName() + " consumed " + data);
            hasData = false;
            condition.signal();//equivalent de notify
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();//dans un finally pour eviter un deadlock
        }
    }


}
