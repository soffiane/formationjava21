package exampreparation;

import java.io.IOException;
import java.nio.file.Path;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiPredicate;

public class Exam {
    /**
     * Java creer originalement pour la television interactive par James Gosling et son equipe pour Sun Microsystem (OAK)
     * En 1995 par Sun
     * Write Once Run Anywhere
     * <p>
     * GraalVM est un JDK qui accelere les performances des application java : services cloud natif java
     * Utilise un compliateur JIT (Just In Time)
     * GraalVM est une VM qui peut comprendre plein d'autres langage de programmation
     * GraalVM peut compiler des app java dans un executable en code natif reduisant le temps de demarrage
     * Une image native GraalVM inclus un sous ensemble du jdk runtime et n'a pas besoin d'une JVM pour s'executer
     * Les images natives consomme moins de memoire qu'une JVM classique
     * Doit etre utilisé en dehors de javac pour creer un native executable
     * <p>
     * Packaging et deploiement
     * - organiser les fichier, compiler le code et le packager dans un format deployable (JAR,WAR,EAR ou executable natifs)
     * mettre en place l'environnement pour executer le deployable
     * jarsigner pour signer un jar (securité)
     * WAR pour les wab app(Servlet,JSP) -> deployé dans un serveur d'application
     * EAR pour les EJB -> deployé dans un conteneur d'EJB
     * GraalVM native image : compiled Ahead of Time (AOT), pas besoin de JVM = moins de memoire et + rapide au demarrage
     * microservices, serverless
     * A besoin de l'API reflexion et du chargement dynamique de classe pour marcher
     * <p>
     * JAR manifest
     * metadata sur le jar, la version le main classe
     * main-class est le point d'entree du jar et doit y etre absolument
     * la classe qui contient le main
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        //print(5,2); --> ambigous call parce qu'on a deux methodes qui correspondent a cet appel
        print(5, 2.0);//on appelle la premier methode : OK

        //operators on boolean
        boolean bool = true;
        //bool++;
        boolean b = bool == true;
        //bool += false;
        //-bool;
        //bool >= false;
        boolean b1 = bool != false;
        boolean b2 = !bool;
        boolean b3 = bool && false;

        /**
         * Rappel : seules les methodes static sont accessible dans le main (car static aussi)
         */

        /**
         * Classe abstraites
         * On appelle le constructeur de Cat et celui de Animal
         */
        Cat2 cat = new Cat2();
        //Animal constructor
        //Cats constructor

        /**
         * API Datetime
         * les zoneID
         */
        ZoneId zoneId = ZoneId.of("America/Chicago");
        ZonedDateTime zdt = ZonedDateTime.of(LocalDate.of(2021, 11, 7), LocalTime.of(1, 30), zoneId);//7 Novembre 2021 a 01h30, heure de Chicago
        ZonedDateTime anHourLater = zdt.plusHours(1);//comme on a annulé le changement d'heure a 2h00 on se retrouve a la meme heure
        System.out.println(zdt.getHour() == anHourLater.getHour());//true
        System.out.println(zdt.getOffset().equals(anHourLater.getOffset()));//false -> parce que zdt est Daylight Saving Time et que anHourLater est en standard time

        /**
         * Duration represente le temps en second et nano : ISO 8601 format
         */
        Duration duration = Duration.ofMillis(5000);//5000ms = 5sec
        System.out.println(duration);//PT5S
        duration = Duration.ofSeconds(60);//60sec est 1minute donc PT1M
        System.out.println(duration);//PT1M
        Period period = Period.ofDays(6);
        System.out.println(period);//P6D

        /**
         * LocalDateTime
         */
        LocalDateTime dateTime = LocalDateTime.of(2018,6,12,10,15,20);
        Period period1 = Period.of(1,1,1);
        dateTime = dateTime.minus(period1);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);//short = tout en nombres
        System.out.println(formatter.format(dateTime));//11/05/2017 10:15

        /**
         * StringBuilder a besoin d'un new pour etre utilisé
         */
        /*StringBuilder stringBuilder = "Certificate";--> erreur ici
        stringBuilder.append(2).deleteCharAt(3).delete(3,stringBuilder.length()-2);
        System.out.println(stringBuilder);*/

        long l = 0b1101_1010;//218 en binaire -> interpreté comme un int, pas un long car dans intervalle du int
        System.out.println(l);

        String s1 = "Java"; //String pool
        String s2 = new String("Java");//normal heap
        String s3 = s2.intern();//retourne le String de la heap dans le String pool
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true

        /**
         * integer et wrapper class
         */
        Integer a = 100;
        Integer c = 100;
        Integer d = 200;
        Integer e = 200;
        //les valeurs d'int comprises entre -128 et 127 sont mises en cache (Cache Integer)
        //donc a ==  c retourne vrai car on les trouvent en cache mais pas d == e car egal a 200
        System.out.println(a == c);//quand on declare c il va cherche a en cache donc a et c sont bien le meme objet
        System.out.println(d == e);//false

        /**
         * List and arrays
         */
        List<String> list = Arrays.asList("A", "B", "C");
        //UnsupportedOperationException car Arras.asList cree une liste de taille fixe
        //list.add("D");
        System.out.println(list);

        /**
         * java.io
         */
        Path path = Path.of("nonexistenddir");
        //Files.walk(path).forEach(System.out::println);//NoSuchFileException at runtime

        /**
         * Threads
         */
        Thread t1 = new Thread(() -> System.out.print("A"));
        Thread t2 = new Thread(() -> System.out.print("B"));

        t1.start();
        t1.join();//on attend que le thread t1 soit executé pour passer a la suite
        t2.start();
        t2.join();

        /**
         * Collections
         */
        //le deuxieme parametre loadFactor est un pourcentage qui definit le taux de remplissage
        //avant lequel la capacité de la hashmap est augmentée automatiquement
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(4, 0.75f, true);
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        //l'appel a la methode get change l'ordre dans la Map
        map.get(1);//place l'entree 1 a la fin de la map
        map.get(3);//place l'entree 3 a la fin de la map
        System.out.println(map);//donc {2=B,1=A,3=C}

        /**
         * Autoboxing et wrapper type
         */
        List<Integer> list1 = List.of(11,12,13,14);
        //Double db = list1.get(0); On ne peut pas directement assigner un Integer dans un Double, il faut le cast
        double db = list1.get(0);//autounboxxing
        int i = list1.get(0);
        //short sh = list1.get(0);un Integer wrapper ne peut pas etre directement assigné a un short
        long lg = list1.get(0);
        Double db2 = Double.valueOf(list1.get(0));

        /**
         * Predicates
         *
         */
        //BiPredicate<Integer,Integer> test = (final Integer x,var y) -> (x.equals(y));//On ne peut pas mixer var avec des types dans un lambda
        BiPredicate<Integer,Integer> test = (var x,final var y) -> (x.equals(y));
        //BiPredicate<Integer,Integer> test = (integer x,final var y) -> (x.equals(y));ca existe meme pas le type integer
        //BiPredicate<Integer,Integer> test = (final var x,y) -> (x.equals(y));il manque le type de y dans le lambda
        //BiPredicate<Integer,Integer> test2 = (integer x,final Intger y)-> (x.equals(y));ca existe meme pas le type integer
    }

    /**
     * methode overriding
     */

    public static void print(int a, double b) {
        System.out.println("int,double");
    }

    public static void print(double a, int b) {
        System.out.println("double,int");
    }

    public static void print(int... values) {
        System.out.println("int Varargs");
    }
}

/**
 * sealed classes : permet d'empecher n'importe quelle classe d'heriter d'une classe
 */
sealed class Animal permits Dog, Cat {
}//seules les classes Dog et Cat peuvent extends Animal

non-sealed class Dog extends Animal {
}//non-sealed donc peut etre extend par n'importe qui, si on utilise sealed il faut preciser les permits

final class Cat extends Animal {
}//class final donc ne peut pas etre extended

abstract class Animal2 {
    public Animal2() {
        System.out.println("Animal constructor");
    }
}

class Cat2 extends Animal2 {
    public Cat2() {
        //super(); --> appel implicite au constructeur de la superclasse
        System.out.println("Cats constructor");
    }
}

/**
 * Un thread en attente ne consomme pas de CPU et doit gerer une InterruptedException (try catch block)
 * Un thread qui a attendu jusqu'a son timeout repasse au status RUNNABLE et attend a nouveau d'avoir du temps CPU, pret a l'execution
 */

/**
 * enums
 */
class Weather {
    public enum Forecast {
        SUNNY, CLOUDY, RAINY;

        private Forecast() {
            System.out.print("C ");
        }

        @Override
        public String toString() {
            return "PROUTLE";
        }
    }

    public static void main(String[] args) {
        System.out.println(Forecast.SUNNY.ordinal());//0
        System.out.println(Forecast.valueOf("cloudy".toUpperCase()));//ici on appelle la methode toString donc PROUTLE
        Forecast weather = Forecast.RAINY;
        //les enums extends implicitement Enum et implements Constable Comparable et Serializable
        System.out.println(weather instanceof Enum);//true
        System.out.println(weather instanceof Comparable);//true
        Forecast f1 = Forecast.RAINY;//appelle le constructeur pour chaque valeur de l'enum
        System.out.println(f1);//appelle le toString
    }
}

/**
 * passage par valeur vs passage par reference
 */

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Tester {
    public static void main(String[] args) {
        Person p = new Person("Joe");
        checkPerson(p);
        System.out.println(p);
        p = null;
        //checkPerson(p);
        //il faut faire p = checkPerson(p); reassigner la reference de p
        System.out.println(p);
    }

    //passage par valeur donc la valeur est modifié mais pas la reference donc p reste egal a null
    public static Person checkPerson(Person p) {
        if (p == null) {
            p = new Person("Mary");
        } else {
            p = null;
        }
        return p;
    }
}


