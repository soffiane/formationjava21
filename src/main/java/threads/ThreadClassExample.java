package threads;

import java.util.concurrent.locks.LockSupport;

/**
 * Un thread est un fil d'execution - la plus petite unité d'execution d'un programme
 * On peut en avoir plusieurs qui s'execute en parallele ou en concurrence dans un programme
 * multitasking
 *
 * Une classe peut extends la classe Thread ou bien l'interface Runnable
 *
 * Threads et Process
 * Fonctionnement
 * On lance un programme -> on cree un process qui a sa propre memoire et ressource les process ne partagent pas les ressources entre eux (isolés)
 * Thread : plus petit qui partage la memoire dans un process, partagent les ressources au sein du meme process
 *
 * JMM : Java Management Memory - gere la consistence des threads et gere la memoire entre les threads
 * Chaque Thread a un petit morceau de memoire de la main memory, il a ses variable locales et quand il les modifie, des processus
 * comme la synchronization permet de mettre la donnée a jour pour les autres threads
 * Thread sont responsives, partage les resources facilement, economiques en ressources
 *
 * Cycle de vie d'un thread :
 * new -> creation du thread
 * ready -> runnable state
 * blocked -> attend que le CPU lui donne la prio ou qu'un autre Thread libere le lock (blocked)
 * running -> le thread a enfin de la ressource et il execute le run()
 * terminated -> il a fini et ne pas etre redemarré
 *
 * Thread Monitoring
 * getState() -> pour savoir le state du Thread
 *
 */
public class ThreadClassExample {
    public static void main(String[] args) {
        //extends Thread
        MyThread myThread = new MyThread();
        System.out.println("avant start : "+myThread.getState());
        myThread.start();//cree un Thread et appelle la methode run(), si on appelle run() directement on a pas la creation du Thread
        System.out.println("apres start : "+myThread.getState());//NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING, TERMINATED
        System.out.println("thread started");
        System.out.println("apres : "+myThread.getState());

        //implements Runnable
        //On instancie un Thread en lui passant la classe qui implemente Runnable
        //Mieux en general pour un code plus flexible pour le Thread Management
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println("runnable started");

    }
}
