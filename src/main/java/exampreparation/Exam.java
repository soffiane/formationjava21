package exampreparation;

import java.time.*;

public class Exam {
    /**
     * Java creer originalement pour la television interactive par James Gosling et son equipe pour Sun Microsystem (OAK)
     * En 1995 par Sun
     * Write Once Run Anywhere
     *
     */

    public static void main(String[] args) {
        //print(5,2); --> ambigous call parce qu'on a deux methodes qui correspondent a cet appel
        print(5,2.0);//on appelle la premier methode : OK

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
        ZonedDateTime zdt = ZonedDateTime.of(LocalDate.of(2021,11,7), LocalTime.of(1,30),zoneId);//7 Novembre 2021 a 01h30, heure de Chicago
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


    }

    /**
     * methode overriding
     */

    public static void print(int a,double b){
        System.out.println("int,double");
    }
    public static void print(double a,int b){
        System.out.println("double,int");
    }
    public static void print(int... values){
        System.out.println("int Varargs");
    }
}

/**
 * sealed classes : permet d'empecher n'importe quelle classe d'heriter d'une classe
 */
sealed class Animal permits Dog, Cat{}//seules les classes Dog et Cat peuvent extends Animal

non-sealed class Dog extends Animal{}//non-sealed donc peut etre extend par n'importe qui, si on utilise sealed il faut preciser les permits

final class Cat extends Animal{}//class final donc ne peut pas etre extended

abstract class Animal2 {
    public Animal2() {
        System.out.println("Animal constructor");
    }
}

class Cat2 extends Animal2{
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
class Weather{
    public enum Forecast{
        SUNNY,CLOUDY,RAINY;

        @Override
        public String toString() {
            return "PROUTLE";
        }
    }

    public static void main(String[] args) {
        System.out.println(Forecast.SUNNY.ordinal());//0
        System.out.println(Forecast.valueOf("cloudy".toUpperCase()));//ici on appelle la methode toString donc PROUTLE
    }
}