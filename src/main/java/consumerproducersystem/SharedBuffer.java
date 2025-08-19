package consumerproducersystem;

import java.util.LinkedList;
import java.util.List;

public class SharedBuffer {
    private final List<Order> orders = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(Order order) throws InterruptedException {
        while(orders.size() == capacity){
            System.out.println("buffer is full. Producer is waiting.....");
            wait();
        }
        orders.add(order);
        System.out.println("Order added to buffer."+order);
        notifyAll();//notify the consumer
    }

    public synchronized Order consume() throws InterruptedException {
        while(orders.isEmpty()){
            System.out.println("buffer is empty. Consumer is waiting.....");
            wait();
        }
        Order order = orders.removeFirst();
        System.out.println("Processing order "+order);
        notifyAll();//notify the consumer
        return order;
    }
}
