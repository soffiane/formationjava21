package threads;

import java.util.concurrent.*;

/**
 * Une maniere d'appeler un service et d'en attendre le resultat, moyen de faire des taches en asynchrone
 *
 */
public class FutureCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //Callable est comme Runnable mais retourne un resultat ou une exception
        Callable<String> callabletask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+" is running callable task");
            Thread.sleep(2000);
            return "Result from "+threadName;
        };
        //submit de l'executor retourne un Future - on peut verifier son etat ou l'annuler
        Future<String> future = executorService.submit(callabletask);
        //le code apres continue a etre executé meme si le submit a pas encore fini
        String result = future.get();//bloque le main() jusqu'a ce que la tache soit executée
        System.out.println("result "+result);
        executorService.shutdown();
    }
}
