package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant Lock, Reetrant Read Write Lock, Condition variables
 * Ameliorer la synchro des thread
 *
 * Reentrant Lock
 * alternative au bloc synchronized
 * Un thread peut reacquirire le meme lock en boucle
 *
 * Read Write Lock
 * + threads peuvent lire en meme temps, un seul peut ecrire
 * lecture concurrente, ecriture un seul thread
 */
public class LocksAndAdvancedSynchronisation {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        Thread thread1 = new Thread(reentrantLockExample::increment,"Thread 1");
        Thread thread2 = new Thread(reentrantLockExample::increment,"Thread 2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        //Thread 1 counter : 1
        //Thread 2 counter : 2
    }
}

class ReentrantLockExample{
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            counter++;
            System.out.println(Thread.currentThread().getName()+" counter : "+counter);
        } finally {
            lock.unlock();
        }
    }
}
