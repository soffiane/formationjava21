package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * On peut planifier des taches avec un delay ou a intervalles fixes
 */
public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();//un seul thread pour tout executer de facon sequentielles
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);//un pool de 4 threads si tous occupés, en attente
        ExecutorService cachedThreadPoll = Executors.newCachedThreadPool();//un pool de thread dont la taille varie selon les besoins
        ExecutorService scheduledThreadPoll = Executors.newScheduledThreadPool(4);
        ExecutorService singleThreadscheduledThreadPoll = Executors.newSingleThreadScheduledExecutor();



        for(int i=0;i<6;i++){
            Task task = new Task("Task "+i);
            scheduledExecutorService.schedule(task,i*2, TimeUnit.SECONDS);//on programme une tache qui se lance toutes les delay seconds
        }
        scheduledExecutorService.scheduleAtFixedRate(new Task("Fixed Rate Task"),1,5,TimeUnit.SECONDS);//commence avec un delai de 1 sec puis se lance toutes les 5 secondes

        scheduledExecutorService.scheduleWithFixedDelay(new Task("Fixed Delay Task"),2,5,TimeUnit.SECONDS);
        //ici on attend la completion de la tache avant de lancer la suivante - on assure un delay entre deux taches quelque soit sa durée

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        scheduledExecutorService.shutdown();//on n'accepte plus de nouvelles taches + on execute celle schedulée
        System.out.println("Shutdown complete");

    }
}

