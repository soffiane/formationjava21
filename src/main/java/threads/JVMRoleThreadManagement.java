package threads;

/**
 * JVM est capital pour creer et gerer les threads
 * Gere leur cycle de vie (NEW, RUNNABLE, RUNNING, BLOCKED/WAITING/TIMED_WAITING, TERMINATED)
 * Map avec les Thread du Systeme d'exploitation
 * Priorisation des thread -> scheduler
 * Changement de contexte
 * Synchronisation des threads
 * Garbage Collection Threads
 * ForkJoinPool et Paralellisme
 *
 */
public class JVMRoleThreadManagement {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new CustomTask(),"T1");
        Thread t2 = new Thread(new CustomTask(),"T2");
        Thread t3 = new Thread(new CustomTask(),"T3");

        System.out.println("T1 State before Start :"+t1.getState());
        System.out.println("T2 State before Start :"+t2.getState());
        System.out.println("T3 State before Start :"+t3.getState());

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);

        System.out.println("T1 State after Start :"+t1.getState());
        System.out.println("T2 State after Start :"+t2.getState());
        System.out.println("T3 State after Start :"+t3.getState());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("T1 State after join :"+t1.getState());
        System.out.println("T2 State after join :"+t2.getState());
        System.out.println("T3 State after join :"+t3.getState());
    }
}

class CustomTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
    }
}
