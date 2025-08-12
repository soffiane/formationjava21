package collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Methode dediée : Collections.binarySearch
 * la liste doit etre triée avant sinon resultat imprevisible
 */
public class SearchingArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(19);
        numbersList.add(11);
        numbersList.add(17);
        numbersList.add(15);
        numbersList.add(39);
        numbersList.add(27);
        numbersList.add(22);

        System.out.println("searching for 17 : "+Collections.binarySearch(numbersList,17));//imprevisible -5
        //on trie la list
        Collections.sort(numbersList);
        //et on reaffiche le resultat
        System.out.println("searching for 17 : "+Collections.binarySearch(numbersList,17));//cette fois ci on trouve 2 c'est correct
        //on cherche un element qui n'est pas dans la liste
        System.out.println("searching for 18 : "+Collections.binarySearch(numbersList,18));//-4 car 11 15 17 -18- 19 22 27 39, il devrait etre a la 4eme place si il etait la

    }
}
