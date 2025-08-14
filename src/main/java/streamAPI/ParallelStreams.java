package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * separation d'un calcul sur plusieurs thread puis on rassemble les resultats
 * + rapide
 * Collections ne sont PAS thread-safe, + threads ne peuvent pas manipuler une collection en meme temps
 * ParallelStream doit etre CONCURRENT et UNORDERED :
 * A eviter dans les Stream :
 * Side effects
 * Lazy
 * Interference
 * Stateful Lambda expression
 */
public class ParallelStreams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("David", "Clark", "Marry", "Sera", "Andy", "Marry");
        //parallele stream - concurrent par le Collector, UNORDERED STREAM par defaut
        ConcurrentMap<Integer, List<String>> namesBylength = names
                .parallelStream()
                .unordered()
                .collect(Collectors.groupingByConcurrent(String::length));
        //l'ordre est important : les thread peuvent process des datas dans un certain ordre
        System.out.println("namesBylength : "+namesBylength);

        Set<Collector.Characteristics> characteristics = Collectors.groupingByConcurrent(n -> "Java").characteristics();
        System.out.println("characteristics : "+characteristics);//[CONCURRENT, UNORDERED, IDENTITY_FINISH]


        names.parallelStream().forEach(System.out::println);//les noms ne sont pas affichés dans l'ordre
        //et si on veut garder l'ordre ? oui mais baisse efficacité
        names.parallelStream().forEachOrdered(System.out::println);

        //Mauvais usage des stream - alimenter une liste dans un stream
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> results = new ArrayList<>();
        numbers.stream().forEach(n -> results.add(n*2));//side effect
        System.out.println(results);

        //BOn usage - on utilise map() et collect() pour creer la liste
        List<Integer> results2 = numbers
                .stream()
                .map(n -> n*2)
                .collect(Collectors.toList());
        System.out.println(results2);

        //Lazy evaluation
        numbers.stream().filter(n -> {
            System.out.println("Filtering "+n);
            return n%2 == 0;
        }).map(n -> {
            System.out.println("Mapping "+n);
            return n*2;
        });//il manque l'operation terminale

        //Interference = ConcureentModificationException
        //en gros quand on modifie une liste pendant qu'on la lit, ca fout la merde
        /*numbers.stream().forEach(n -> {
            if(n==3){
                numbers.remove(n);
            }
        });*/
        
        //utilisation correcte
        List<Integer> collect = numbers.stream().filter(n -> n != 3).collect(Collectors.toList());

        //Statufeul lambda expression
        //Un stream doit rester stateless et ne pas dependre de l'etat d'un autre objet
        //ici on essaie d'alimenter une collection non thread safe dans un stream parallele, resultat impredictible
        numbers.parallelStream()
                .map(n -> {
                    results.add(n); //statefull usage
                    return n*2;
                })
                .forEach(System.out::println);
        //on va plutot créer une nouvelle liste
        List<Integer> collect1 = numbers.parallelStream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("collect1 "+collect1);
    }
}
