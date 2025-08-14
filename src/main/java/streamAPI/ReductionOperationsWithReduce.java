package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * RELIRE SUR MAP-REDUCE
 *
 * Operation sur un stream permettant de renvoyer une seule valeur ou une nouvelle collection
 * methodes : average(), sum(), max(), min() count()
 * methodes : reduce() et collect() (souvent avec map() )
 * reduce() :
 * collect() :
 */
public class ReductionOperationsWithReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,5,3,12,8);
        //rappel sur Optional : pour eviter les NPE sur la valeurs
        //si la liste est vide, on peut avoir la somme nulle
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        sum.ifPresent(System.out::println);
        //par contre si on rajoute une valeur pour identity, on va forcement avoir une valeur dans la somme donc pas de Optional
        Integer sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum2 : "+sum2);


        //on va calculer la moyenne des nombres impairs de cette liste
        double average = numbers.stream()
                .filter(n -> n%2 == 1)
                .mapToInt(n -> n*2)//maptoint renvoie un IntStream au lieu d'un Stream
                .average()//notre reduction qui renvoie un OptionalDouble
                .getAsDouble();
        System.out.println(average);

        //reduce
        int total = numbers.stream()
                .filter(n -> n%2 == 1)
                .mapToInt(n -> n*2)
                .sum();
        System.out.println("total : "+total);

        //reduce prend 2 params : identity, la valeur de depart et le binary operator qui est l'aggregator des valeurs du stream
        int total2 = numbers.stream()
                .filter(n -> n%2 == 1)
                .mapToInt(n -> n*2)
                .reduce(0, Integer::sum);
        System.out.println("total2 : "+total2);//meme resultat que total

        //collect()
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n%2 == 1)
                .collect(Collectors.toList());

        //ou
        List<Integer> oddNumbers2 = numbers.stream()
                .filter(n -> n%2 == 1)
                .toList();

        Optional<Integer> max = numbers.stream().reduce((a, b) -> a > b ? a : b);
        max.ifPresent(System.out::println);
        Optional<Integer> min = numbers.stream().reduce((a, b) -> a < b ? a : b);
        min.ifPresent(System.out::println);
    }
}
