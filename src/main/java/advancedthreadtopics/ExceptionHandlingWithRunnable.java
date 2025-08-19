package advancedthreadtopics;

/**
 * Une exception non ou mal gérée dans un thread peut terminer le thread sans notifier le main thread
 * avec Runnable et Callable
 * ou avec UncaughtExceptionHandler
 * Les exceptions dans les Thread ne se propagent pas dans le main thread contrairement au cas standard
 * Les thread ont leur propre environnement d'execution, une exception peut laisser des taches incompletes sans qu'on ne le sache (et des inconsistences de données etc..)
 * Fuites de ressources : fichier ouvert, BDD ouvertes etc....
 */
public class ExceptionHandlingWithRunnable {
    public static void main(String[] args) {
        Runnable task = () -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " task started");
                    double value = Math.random();
                    System.out.println("Generated number by " + Thread.currentThread().getName() + " is " + value);
                    if (value > 0.5) {
                        throw new RuntimeException("Simulation error");
                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " task completed");
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " Exception : " + e.getMessage());
                    break;
                }
            }
        };

        Thread t1 = new Thread(task,"T1");
        Thread t2 = new Thread(task,"T2");

        t1.start();
        t2.start();

    }

}
