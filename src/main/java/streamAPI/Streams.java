package streamAPI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream est une interface
 * API pour parcourir des collections, le stream ne garde pas la collection une fois consommée
 * 3 methodes de parcours de collections :
 *  - les boucles (for-each)
 *  - Iterator
 *  - Stream API
 *
 * pipeline : c'est une aggregation d'operation sur un stream
 * Stream facilite les operation sur de large data set, plus propre et en parallele
 * + efficace que les boucles et les iterators
 */
public class Streams {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5,2,3,1,4);
/*
        //for each
        for(Integer i : numbers){
            System.out.println(i);
        }
        //ou encore
        numbers.forEach(System.out::println);

        //iterator
        Iterator<Integer> iterator = numbers.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Stream
        numbers.stream().forEach(n -> System.out.println(n));
        //ou encore
        numbers.stream().forEach(System.out::println);
*/
        //exemple de pipeline sur un stream
        numbers.stream()
                .filter(n -> n%2 == 0)//on filtre des elements du stream
                .map(n -> n+1)//map applique une function a chaque element du stream
                .sorted()//on ordonne la collection issue du map()
                .distinct()//on enleve les doublons
                .forEach(System.out::println);

        Stream<Integer> integerStream = numbers.stream();
        integerStream.forEach(n -> System.out.println("Avant dernier impression : "+n));
        //integerStream.forEach(n -> System.out.println("derniere impression : "+n));//IllegalStateExpression -> stream deja consommé
    }
}
