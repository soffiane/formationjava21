package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Triage par ordre naturel
 * chiffre puis lettre majuscule puis minuscule
 */
public class SortingArrayList {
    public static void main(String[] args) {
        List<Double> list1 = new ArrayList<>();
        list1.add(2.3);
        list1.add(11.0);
        list1.add(4.6);
        list1.add(-3.6);
        list1.add(0.8);
        list1.add(12.3);

        System.out.println("list1 : "+list1);
        Collections.sort(list1);
        System.out.println("sortedList "+ list1);
    }
}
