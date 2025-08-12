package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Interface Iterator : permet de parcourir une Collection element par element : un curseur
 * methodes
 * hasNext() -> est-ce qu'il y a un element apres ? true ou false
 * next() -> on passe a l'element suivant
 * remove() -> retire l'element suivant
 * On ne peut qu'avance, et pas reculer
 *
 * ListIterator
 * ajoute des methodes pour reculer dans une liste -> mieux qu'Iterator
 * hasPrevious() -> si on peut reculer dans la liste = true
 * previous -> on place le curseur a l'element precedent
 * previousIndex() / nextIndex() -> renvoie l'element avant ou apres l'index
 * set() -> remplace un element
 * add() -> ajoute un element
 */
public class ListIteratorExample {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        for(int i =1;i<51;i++){
            numberList.add(i);
        }
        //Iterator
        /*Iterator<Integer> iterator = numberList.iterator();
        while(iterator.hasNext()){
            int next = iterator.next();
            if(next % 3 != 0){
                iterator.remove();
            }
        }
        System.out.println("numberList : "+numberList);*/

        //ListIterator
        ListIterator<Integer> listIterator = numberList.listIterator();
        while(listIterator.hasNext()){
            int indexes = listIterator.nextIndex();
            System.out.println(indexes +" ");
            int element = listIterator.next();
            if(element % 3 != 0){
                listIterator.set(-1);
            }
        }
        System.out.println("numberListIterator : "+numberList);
    }
}
