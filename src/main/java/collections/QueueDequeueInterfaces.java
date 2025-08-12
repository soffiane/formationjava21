package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Interface Queue -> FIFO First In First Out
 * Gestion des messages
 * Implementation PriorityQueue
 *
 * Interface Deque : Double Ended Queue -> LIFO Last In First Out et FIFO en meme temps
 * On peut ajouter/supprimer des elements des deux bouts de la Queue
 * Implementation ArrayDeque / LinkedList
 *
 * peek, element, remove et poll agissent sur le premier element de la queue qui est celui qui a ete inseré en 1er dans la queue -> FIFO
 */
public class QueueDequeueInterfaces {

    public static void main(String[] args) {
        /*------------------------------- QUEUE -----------------------------------------------*/
        Queue<String> carsQueue = new LinkedList<>();
        carsQueue.add("Mercedes");//peut lancer une exception si pb
        carsQueue.offer("Ferrari");
        carsQueue.offer("Ford");
        carsQueue.offer("BMW");
        carsQueue.offer("Opel");

        System.out.println("carsQueue : "+carsQueue);
        System.out.println("size : "+carsQueue.size());
        System.out.println("First element : "+carsQueue.element());//peut lancer une exception si element absent
        System.out.println("First element : "+carsQueue.peek());//ne lance pas d'exception
        System.out.println("Remove element : "+carsQueue.poll());//renvoie null si element absent
        System.out.println("carsQueue : "+carsQueue);
        System.out.println("size : "+carsQueue.size());
        System.out.println("Remove element : "+carsQueue.remove());//exception si element absent
        System.out.println("carsQueue : "+carsQueue);
        System.out.println("size : "+carsQueue.size());

        /*------------------------------- DEQUE -----------------------------------------------*/

        Deque<String> carsDeque = new LinkedList<>();
        carsDeque.add("Mercedes");//peut lancer une exception si pb
        carsDeque.add("Ferrari");
        carsDeque.add("Ford");
        //l'interface a ses methodes pour ajouter au deux bouts de la queue
        carsDeque.addLast("BMW");
        carsDeque.addFirst("Opel");
        carsDeque.push("Honda");//pousse l'element au debut de la queue
        carsDeque.offer("Hyundai");//pousse à la fin
        carsDeque.offerFirst("Kya");//passe devant Honda
        carsDeque.offerLast("Renault");//passe apres Hyundai

        System.out.println("carsDeque : "+carsDeque);
        System.out.println("Remove first element : "+carsDeque.removeFirst());
        System.out.println("carsDeque : "+carsDeque);
        System.out.println("Remove last element : "+carsDeque.removeLast());
        System.out.println("carsDeque : "+carsDeque);

        /*System.out.println("size : "+carsDeque.size());
        System.out.println("First element : "+carsDeque.element());//peut lancer une exception si element absent
        System.out.println("First element : "+carsDeque.peek());//ne lance pas d'exception
        System.out.println("Remove element : "+carsDeque.poll());//renvoie null si element absent
        System.out.println("carsDeque : "+carsDeque);
        System.out.println("size : "+carsDeque.size());
        System.out.println("Remove element : "+carsDeque.remove());//exception si element absent
        System.out.println("carsQueue : "+carsDeque);
        System.out.println("size : "+carsDeque.size());*/


    }
}
