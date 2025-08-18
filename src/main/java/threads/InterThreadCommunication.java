package threads;

/**
 * Semaphore comme mecanisme central de coordination
 * Il stocke des permits d'acces a des ressources pour les threads
 * Le Thread wait pour le permis et une fois utilisé le release
 * <p>
 * Un thread peut se mettre en pause pour attendre un autre thread
 * wait() : libere le lock et se met en waiting
 * notify() : reveille un thread en wait
 * notifyAll() : reveille tous les thread en wait
 */
public class InterThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer sharedBuffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for(int i =0;i<5;i++){
                sharedBuffer.produce(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Producer");

        Thread consumer = new Thread(() -> {
            for(int i =0;i<5;i++){
                sharedBuffer.consume();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
        //Producer et Consumer sont bien coordonnés
    }
}

class SharedBuffer {
    private int data;
    private boolean hasData = false;

    //producer
    public synchronized void produce(int value) {
        //on attend que le buffer soit disponible pour ecrire dedans
        while (hasData) {
            try {
                wait();//on attend le notify() du consumer
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        data = value;
        System.out.println((Thread.currentThread().getName() + " produced " + data));
        hasData = true;
        notify();//reveille consumer
    }

    public synchronized void consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " consumer " + data);
        hasData = false;
        notify();
    }
}
