package consumerproducersystem;

public class MainTest {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);
        Thread producer = new Thread(new Producer(sharedBuffer),"producer-thread");
        Thread consumer = new Thread(new Consumer(sharedBuffer), "consumer-thread");

        producer.start();
        consumer.start();

    }
}
