package threads;

/**
 * Quand + threads essaient d'acceder a la meme ressource, il faut empecher les threads de se marcher dessus
 * Il faut s'assurer qu'un seul Thread s'execute a la fois -> synchronized
 * mot clé volatile -> si + threads lise la meme valeur en meme temps (dirty read)
 * volatile permet a tous les threads de voir la valeur a jour immediatement
 */
public class ThreadSynchronisation {
    public static void main(String[] args) {
        Counter counter = new Counter();
        //on va creer deux thread et voir comment ils accedent a la variable count
        //race conditions
        Thread thread1 = new Thread(() -> {
            for(int i =0; i<1000;i++){
                counter.increment();
                System.out.println("Thread 1 : "+counter.getCount());
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i =0; i<1000;i++){
                counter.increment();
                System.out.println("Thread 2 : "+counter.getCount());
            }
        });
        //les threads s'executent en parallele
        thread1.start();
        thread2.start();

        try {
            //on attend que le thread se terminent
            thread1.join();
            thread2.join();
            System.out.println("counter value : "+counter.getCount());//on aura pas 2000 ici -1968
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Counter {
    private int count = 0;

    public synchronized void increment(){
        //ce n'est pas une atomic operation
        count++;
    }

    public int getCount() {
        return count;
    }
}
