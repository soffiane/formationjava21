package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * On peut ecrire ses propres Comparator en implementant l'interface Comparator
 */
public class ComparatorInterface {
    public static void main(String[] args) {

        /*ArrayList<Character> charsList = new ArrayList<>();
        charsList.add('b');
        charsList.add('Z');
        charsList.add('A');
        charsList.add('Z');
        charsList.add('d');
        charsList.add('F');

        System.out.println("unsorted list : "+charsList);
        Collections.sort(charsList, new CharComparator());
        System.out.println("sorted list : "+charsList);*/

        ArrayList<Cars> carsList = new ArrayList<>();
        carsList.add(new Cars("Mercedes", 2020, 10000));
        carsList.add(new Cars("BMW", 2018, 12000));
        carsList.add(new Cars("Ferrari", 2025, 20000));
        carsList.add(new Cars("Ford", 2024, 15000));
        carsList.add(new Cars("Opel", 2020, 18000));

        Comparator<Cars> comparator = Comparator.comparing(Cars::getPrice);
        Collections.sort(carsList, comparator);// ou carsList.sort(comparator)
        for (Cars car : carsList) {
            System.out.println("Car : " + car.getCarName() + " Year : " + car.getYear() + " Price : " + car.getPrice());
        }

    }
}

class CharComparator implements Comparator<Character> {

    @Override
    public int compare(Character o1, Character o2) {
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 0;
        }

    }
}

class Cars {
    private String carName;
    private int year;
    private int price;

    public Cars(String carName, int year, int price) {
        this.carName = carName;
        this.year = year;
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}
