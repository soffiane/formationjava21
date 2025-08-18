package threads;
/**
 * Executor Framework
 * task scheduling
 * rend la creation et la gestion de threads plus simple
 * Thread Pool -> fixed, cached (dynamic), single thread (execution sequentielle), scheduled (timers)
 *
 * Concurrent Collection
 * Thread safe data structure
 * pas de gestion manuelle de thread
 *
 * Future / Callable Interface
 * resultat asynchrone d'une operation, le future permet de check si la tache est finie ou pas
 * et on recupere le resultat plus tard
 *
 * Atomic variables
 * evite les interference de thread lors de la lecture de variable (dirty read)
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        //pool de 3 threads pour 6 taches - les taches en trop sont dans la queue en attente
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<6;i++){
            Task task = new Task("Task "+i);
            executorService.submit(task);//soumet une tache a l'execution et renvoie un Future
        }
        executorService.shutdown();
        System.out.println("All tasks submitted");

        //si la tache attend pendant plus de 60 secondes
        try {
            if(!executorService.awaitTermination(60, TimeUnit.SECONDS)){
                //on force l'interruption
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


