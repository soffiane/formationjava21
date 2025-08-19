package threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread contention se produit quand + threads essaie d'acceder a des ressources partageés
 * Ca peut aboutir a des delais car les threads doivent attendre leur tour -> baisse de performance si mal gerée
 * -> trop de synchronized, attendre des IO pour completer, competition pour les lock dans hashmap
 * -> solution : reduire la portée des lock, utiliser des concurrent data structures, optimiser les sections critique de code
 *
 * Deadlock :
 * 2 thread attendent l'un l'autre qu'il libere le lock -> eviter les nested locks, lock ordering, timeouts
 */
public class ThreadContention {

    private static final ReentrantLock LOCK = new ReentrantLock();
    private static int counter = 0;//shared ressource
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for(int i = 0;i<6;i++){
                LOCK.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" increments counter");
                    counter++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName()+" release the lock");
                    LOCK.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task,"Thread-1");
        Thread thread2 = new Thread(task,"Thread-2");
        Thread thread3 = new Thread(task,"Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
