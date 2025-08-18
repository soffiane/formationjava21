package threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExampleTest {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample reentrantLockExample = new ReadWriteLockExample();
        Thread writerThread = new Thread(() -> reentrantLockExample.write(49), "Writer Thread");

        Thread readThread1 = new Thread(reentrantLockExample::read, "Reader Thread 1");
        Thread readThread2 = new Thread(reentrantLockExample::read, "Reader Thread 2");

        writerThread.start();
        readThread1.start();
        readThread2.start();

        writerThread.join();
        readThread1.join();
        readThread2.join();

    }
}
class ReadWriteLockExample {
    //on definit des locks pour lecteur et pour ecriture
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    private int data = 0;

    //write
    public void write(int value){
        writeLock.lock();
        try{
            data = value;
            System.out.println(Thread.currentThread().getName()+" wrote "+data);
        } finally {
            writeLock.unlock();
        }
    }

    //read
    public void read(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" read "+data);
        } finally {
            readLock.unlock();
        }
    }
}
