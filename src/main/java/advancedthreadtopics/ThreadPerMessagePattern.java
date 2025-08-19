package advancedthreadtopics;

import java.util.ArrayList;
import java.util.List;

/**
 *  * Thread Per Message pattern :
 *  * Un thread est crée pour chaque requete ou tache
 *  * Simple a implementé et utile pour des taches legeres et independantes
 *  * Facilite la gestion des taches grace au 1 Thread/1Tache
 *  * Inconvenients :
 *  * Perfomance issues pour des taches lourdes
 *  * tres consommateur de resources
 */
public class ThreadPerMessagePattern {
    public static void main(String[] args) {
        List<String> messages = new ArrayList<>();
        messages.add("Message 1");
        messages.add("Message 2");
        messages.add("Message 3");
        messages.add("Message 4");
        messages.add("Message 5");

        //1 thread est cree par message et sont traités en parallele
        for(String message : messages){
            Thread thread = new Thread(new PrintRequestHandler(message));
            thread.start();
        }
    }
}

class PrintRequestHandler implements Runnable{

    private String message;

    public PrintRequestHandler(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" processing "+message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" processed message "+message);
    }
}
