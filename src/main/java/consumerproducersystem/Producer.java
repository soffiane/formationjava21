package consumerproducersystem;

import java.util.Random;

public class Producer implements Runnable{
    private SharedBuffer sharedBuffer;
    private int orderId = 0;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        String[] products = {"Laptop","Phone","Keyboard","Headphone","Monitor"};
        Random random = new Random();

        while (true){
            try{
                String productName = products[random.nextInt(products.length)];
                int quantity = random.nextInt(1,6);
                Order order = new Order(++orderId,productName,quantity);
                sharedBuffer.produce(order);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
