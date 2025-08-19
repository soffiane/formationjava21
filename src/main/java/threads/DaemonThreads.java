package threads;

/**
 * User threads vs Deamon Threads
 * Le GC est un Daemon, il tourne en tache de fond sans perturber l'execution d'un programme
 * setDaemon()
 * tache comme le monitoring, le nettoyage et les taches periodiques
 */
public class DaemonThreads {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            for(int i =0;i<=5;i++){
                System.out.println("userThread : "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"userThread");

        Thread daemonThread = new Thread(() -> {
            while(true){
                System.out.println("daemonThread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"daemonThread");//le daemon s'arrete quand la JVM s'arrete

        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();
    }
}
