package threads;

class VolatileExample {

    //ecrit en main memory et vue par tous les thread (pas de problemes de cache)
    private volatile boolean running = true;

    public void stopRunning(){
        running = false;
    }

    public void run(){
        while(running){
            System.out.println("Thread is running....");
        }
        System.out.println("Thread is stopped");
    }
}

public class VolatileTest{
    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();

        Thread thread = new Thread(volatileExample::run);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //le thread s'arrete car le boolean est passé a false et qu'il l'a vu
        volatileExample.stopRunning();
    }
}
