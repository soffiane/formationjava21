package threads;

import java.util.concurrent.*;

/**
 * Il faut optimiser pour prevenir les problemes lies aux ressources (trop ou pas assez)
 * Different types de thread pool (fixed, cached.....), chacun a son utiité selon le contexte
 * Mettre un timeout sur une tache
 * Monitoring
 */
public class OptimizeThreadPool {
    public static void main(String[] args) {
        //on cree un pool de 3 thread, si tous les threads sont occupés les task sont mises en queue
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<Double> task1 = () -> {
            System.out.println(Thread.currentThread().getName()+ " is calculating the square of 5");
            return Math.pow(5,2);
        };
        Callable<Double> task2 = () -> {
            System.out.println(Thread.currentThread().getName()+ " is calculating the square of 7");
            return Math.pow(7.0,2);
        };
        Callable<Double> task3 = () -> {
            System.out.println(Thread.currentThread().getName()+ " is calculating the square of 10");
            return Math.pow(10.0,2);
        };

        //on collecte les resultats des task Callable via des Future
        Future<Double> result1 = executorService.submit(task1);
        Future<Double> result2 = executorService.submit(task2);
        Future<Double> result3 = executorService.submit(task3);

        try {
            //le get met le programme en attente jusqua ce que le calcul soit fait
            System.out.println("Square of 5 is : "+result1.get());
            System.out.println("Square of 7 is : "+result2.get());
            System.out.println("Square of 10 is : "+result3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

    }
}
