package DateTimeAPI;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Classe IMMUTABLE qui represente une date anne mois jours heure minutes secondes
 * LocalDate + LocalTime
 * pas de timezone
 * THREAD-SAFE
 * Classe final sans constructeur, methodes static
 */
public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime : "+localDateTime);//2025-08-15T16:29:06.738909200
        System.out.println("Hash avant : "+System.identityHashCode(localDateTime));

        int year = localDateTime.getYear();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        Month month = localDateTime.getMonth();
        System.out.println("year : "+year);
        System.out.println("hour : "+hour);
        System.out.println("minute : "+minute);
        System.out.println("month : "+month);

        LocalDateTime minus5Days = localDateTime.minusDays(5);
        System.out.println("minus5Days : "+minus5Days);

        LocalDateTime plus5Months = localDateTime.plusMonths(5);
        System.out.println("plus5Months : "+plus5Months);

        //Immutable
        localDateTime = localDateTime.minusDays(1);
        //on a cree une nouvelle instance de LocalDateTime
        System.out.println("Hash apres : "+System.identityHashCode(localDateTime));
        System.out.println("localDateTime : "+localDateTime);//2025-08-15T16:29:06.738909200

        LocalDateTime birthDay = LocalDateTime.of(1986,5,21,11,30);
        System.out.println("birthDay : "+birthDay);

        System.out.println("birthDay after dateTime ? "+birthDay.isAfter(localDateTime));
        System.out.println("birthDay before dateTime ? "+birthDay.isBefore(localDateTime));
    }
}
