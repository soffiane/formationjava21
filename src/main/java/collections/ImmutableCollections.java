package collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * mapMulti() introduit dans java21 pour les streams peut remplacer flatMap
 * car plus efficace dans certains cas car evite la creation de stream intermediaires
 */
public class ImmutableCollections {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        List<Integer> result = numbers.stream()
                .<Integer>mapMulti((num, consumer) -> {
                    if (num % 2 == 0) {
                        consumer.accept(num);
                        consumer.accept(num * 2);
                    }
                })
                .collect(Collectors.toList());//[2, 4]

        //avec flatMap on cree des Stream intermediaire
        List<Integer> result2 = numbers.stream()
                .flatMap(num -> {
                    if (num % 2 == 0) {
                        return Stream.of(num, num * 2);
                    } else {
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toList());//[2, 4]
        List<Integer> numbers2 = List.of(3, 6, 2, 8, 5, 9);

        //la somme des elements via summingInt est 3+6+2+8+5+9=33
        //la seconde collections comptes les elements soit 6
        //le teeing va merger les resultats des deux collections via une fonction qui est ici sum/count soit 33/6 = 5
        var result3 = numbers2.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(n -> n),
                        Collectors.counting(),
                        (sum, count) -> sum / count
                ));//5

        System.out.println(result3);

        System.out.println(result);
        System.out.println(result2);
    }
}
