package DateTimeAPI;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represente une quantité de temps, une periode de temps
 * ISO-8601 '2 years, 3 months and 4 days'
 * supporte les années mois et jours
 * IMMUTABLE et THREAD-SAFE
 * Pas de constructeur et final, methodes static
 */
public class PeriodClassExample {
    public static void main(String[] args) {
        Period period = Period.of(5,11,20);
        System.out.println(" period : "+period);//P5Y11M20D

        LocalDate currentDate = LocalDate.now();
        System.out.println(" currentDate : "+currentDate);//2025-08-15

        LocalDate afterPeriod = currentDate.plus(period);
        System.out.println(" afterPeriod : "+afterPeriod);//2031-08-04

        LocalDate birthday = LocalDate.of(2026,5,21);
        System.out.println("remaining time to my birthday : "+ Period.between(birthday,currentDate));//P-9M-6D dans 9mois et 6jours

    }
}
