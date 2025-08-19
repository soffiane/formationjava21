package consumerproducersystem;

public class Consumer implements Runnable {
    private final SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        while(true){
            try{
                Order consume = sharedBuffer.consume();
                System.out.println(Thread.currentThread().getName() + " delivered order "+consume);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
