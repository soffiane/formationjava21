package threads;

import java.util.List;

/**
 * Parallel Stream decoupe la collection en petit morceau chaque morceau est traité par un thread diff
 * ForkJoinPool -> threadpool des paralel stream
 * Stateless Operation : eviter les operation qui modifie des valeurs car risque de probleme de thread safety
 * thread overhead : si collection trop petite, peut etre plus lent que pour traitemetn sequentiel
 * Eviter Parallel stream sur les petites collection ou pour celle pouvant amener a des problemes de thread safety
 * Attention a la gestion des ressources
 */
public class ParallelStreams {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        numbers.parallelStream().forEach(number -> {
            System.out.println(Thread.currentThread().getName()+ " , Number "+number+" square "+(number*number));
        });
        /*
        ForkJoinPool.commonPool-worker-3 , Number 5 square 25
        ForkJoinPool.commonPool-worker-6 , Number 8 square 64
        ForkJoinPool.commonPool-worker-2 , Number 2 square 4
        ForkJoinPool.commonPool-worker-6 , Number 1 square 1
        ForkJoinPool.commonPool-worker-3 , Number 10 square 100
        ForkJoinPool.commonPool-worker-4 , Number 9 square 81
        ForkJoinPool.commonPool-worker-7 , Number 4 square 16
        ForkJoinPool.commonPool-worker-5 , Number 6 square 36
        ForkJoinPool.commonPool-worker-1 , Number 3 square 9
         */
    }
}
