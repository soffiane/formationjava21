package threads;
/**
 * Priorité des Thread : une valeur allant de 1 a 10 du plus faible au plus fort
 * Attention au risque de Starvation, a savoir des threads de faible priorité qui n'obtiennent jamais la main
 * Fairness mecanisme : pour limiter le starving
 * Changing proirity avec setPriority
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> {
            for(int i =0;i<=5;i++){
                System.out.println("High-priority : "+i);
            }
        },"HighPriorityThread");

        Thread mediumPriorityThread = new Thread(() -> {
            for(int i =0;i<=5;i++){
                System.out.println("Medium-priority : "+i);
            }
        },"MediumPriorityThread");

        Thread lowPriorityThread = new Thread(() -> {
            for(int i =0;i<=5;i++){
                System.out.println("lowPriorityThread : "+i);
            }
        },"LowPriorityThread");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        mediumPriorityThread.setPriority(Thread.NORM_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        mediumPriorityThread.start();
        lowPriorityThread.start();
    }
}
