package toolsandtesting;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Pas facile de debbugger les application multithread
 * Problemes communs
 * race condition : + thread accedent aux resources partagees sans synchro -> resultat imprevisible
 * deadlock : thread s'attendent l'un autre et bloquent le systeme
 * thread leaks : un thread non terminé et consomme des ressources
 * thred piority issues : bottleneck et comportement inattendu
 * probleme de synchro : dur a reproduire
 * <p>
 * On a des outils et techniques pour debuger :
 * Thread Dump Analysis Tools -> jstack, VisualVM
 * IDE Tools peuvent debugger les threads
 * Profilers : YourKit, JProfiler
 * Logging tools : Log4j, SLF4j
 * Static Analysis tools : FindBugs, SonarQube
 *
 * On peut debugger le process avec jps et jstack
 */
public class DeadLockExample {
    private final static ReentrantLock lock1 = new ReentrantLock();
    private final static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Runnable task1 = () -> {
            try {
                lock1.lock();
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                Thread.sleep(1000);
                lock2.lock();
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                Thread.sleep(1000);
                lock2.unlock();
                Thread.sleep(1000);
                lock1.unlock();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        //il faut changer l'ordre d'acquisition des lock pour regler le deadlock
        Runnable task2 = () -> {
            try {
                lock2.lock();
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                Thread.sleep(1000);
                lock1.lock();
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                Thread.sleep(1000);
                lock1.unlock();
                Thread.sleep(1000);
                lock2.unlock();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();

        //Thread-2 acquired lock2
        //Thread-1 acquired lock1
        //puis le programme est bloqué - deadlock

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
