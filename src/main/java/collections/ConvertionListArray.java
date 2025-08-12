package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertionListArray {
    public static void main(String[] args) {

        //Convertion d'une List en Array : toArray() ou toArray(T[]a)
        //Object[] array = animals.toArray();

        //Object[] array2 = new Object[animals.size()];
        //array2 = animals.toArray(array2);

        List<String> animalsList = new ArrayList<>();
        animalsList.add("Cat");
        animalsList.add("Dog");
        animalsList.add("Cow");
        String[] animalsArray = new String[animalsList.size()];
        for(int i = 0;i < animalsList.size();i++){
            animalsArray[i] = animalsList.get(i);
        }
        //ou plus simple
        Object[] animalsArray2 = animalsList.toArray();

        System.out.println("animalsList "+animalsList);
        System.out.println("animalsArray2 "+ Arrays.toString(animalsArray2));

        //Conversion Array -> List
        String[] carsArray = {"Ferrari","Mercedes","BMW","Ford"};
        List<String> carsList = Arrays.asList(carsArray);
        //ON NE PEUT PAS AJOUTER DELEMENT A UNE LISTE AVEC ARRAYS.ASLIST mais on peut en modifier les elements avec set()
        //carsList.add("Opel");//UnsupportedOperationException
        //carsList.set(0,"Opel");
        //ArrayList<String> carsList = new ArrayList<>(Arrays.asList(carsArray));
        //ArrayList<String> carList2 = new ArrayList<>();
        //Collections.addAll(carList2,carsArray);
        System.out.println("carsArray : "+Arrays.toString(carsArray));
        System.out.println("carsList : "+carsList);
    }
}
