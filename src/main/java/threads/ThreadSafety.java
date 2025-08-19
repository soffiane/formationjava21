package threads;

/**
 * race condition : quand + thread accedent a la meme ressource
 * critical section : la portion de code qui ne doit etre executé par un seul thread a la fois
 *
 * techniques :
 * synchronization
 * locks
 * volatile variables
 * atomic variables
 * Immutable objects
 *
 * Pourquoi c'est important l'immutabilité ? Thread safe, consistent, easy to debug, better performance
 * final class
 * private final fields
 * pas de setter dans les objets
 * deep copying of mutable fields
 * les getters et methodes renvoient des nouvelles instances de l'objet
 */
class ThreadSafetyCounter {

    private int counter = 0;

    public synchronized void increment(){
        counter++;
        System.out.println(Thread.currentThread().getName()+ " increment the counter to "+counter);
    }

    public int getCounter() {
        return counter;
    }
}

public class ThreadSafety{
    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyCounter threadSafetyCounter = new ThreadSafetyCounter();

        Runnable task = threadSafetyCounter::increment;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
