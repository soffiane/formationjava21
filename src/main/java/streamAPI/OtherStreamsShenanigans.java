package streamAPI;

import java.util.stream.Stream;

public class OtherStreamsShenanigans {
    public static void main(String[] args) {
        //si la liste n'est pas ordonné on drop que le premier element qui respecte le predicat
        Stream.of(1, 2, 3, 1)
                .dropWhile(i -> i < 2)
                .forEach(System.out::println);//2 3 1

        System.out.println("====");
        //si la liste est ordonné forcement on droppe tous les premiers elements qui respecte le predicat (donc tous puisqu'ordonnées
        Stream.of(1, 2, 2, 3, 3, 4, 5)
                .dropWhile(i -> i < 3)
                .forEach(System.out::println);// 3 3 4 5

        System.out.println("====");

        Stream.of(1, 2, 3, 1)
                .filter(i -> i < 2)
                .forEach(System.out::println);// 1 1
    }
}
