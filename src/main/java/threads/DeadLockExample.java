package threads;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    private static final ReentrantLock lock1= new ReentrantLock();
    private static final ReentrantLock lock2= new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            lock1.lock();
            try{
                System.out.println("Thread1 acquire lock1. Waiting for lock2....");
                Thread.sleep(1000);
                lock2.lock();{
                    try{
                        System.out.println("Thread1 acquire lock2");
                    } finally {
                        lock2.unlock();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                lock1.unlock();
            }
        };


        Runnable task2 = () -> {
            lock2.lock();
            try{
                System.out.println("Thread2 acquire lock2. Waiting for lock1....");
                Thread.sleep(1000);
                lock1.lock();{
                    try{
                        System.out.println("Thread2 acquire lock2");
                    } finally {
                        lock1.unlock();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                lock2.unlock();
            }
        };

        Thread thread1 = new Thread(task1,"Thread-1");
        Thread thread2 = new Thread(task2,"Thread-2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
