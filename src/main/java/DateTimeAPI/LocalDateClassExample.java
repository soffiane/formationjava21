package DateTimeAPI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

/**
 * LocalDate is IMMUTABLE et represente une date au format year-month-day
 * Ne stocke pas le temps ou une time zone
 * LocalDate est THREAD-SAFE
 * LocalDate est final et n'a pas de constructeur, toutes les methodes sont static
 */
public class LocalDateClassExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("current date : "+localDate);//la date du jour

        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int monthValue = localDate.getMonthValue();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfMonth = localDate.getDayOfMonth();
        int dayOfYear = localDate.getDayOfYear();

        System.out.println("Current year : "+year);
        System.out.println("Current month : "+month);
        System.out.println("Current monthValue : "+monthValue);//8 pour le mois d'aout donc intervalle 1 - 12
        System.out.println("Current dayOfMonth : "+dayOfMonth);
        System.out.println("Current dayOfYear : "+dayOfYear);
        System.out.println("Current dayOfWeek : "+dayOfWeek.getValue());//5 pour FRIDAY dans LocalDate
        System.out.println("Current dayOfWeek in Calendar: "+ Calendar.getInstance().get(Calendar.DAY_OF_WEEK));//6 pour FRIDAY dans Calendar

        LocalDate twoWeeksAgo = localDate.minusWeeks(2);
        System.out.println("twoWeeksAgo : "+twoWeeksAgo);//2025-08-01
        LocalDate plus5Days = localDate.plusDays(5);
        System.out.println("plus5Days : "+plus5Days);//2025-08-20

        LocalDate wedingDate = LocalDate.of(2016,Month.JULY,17);
        System.out.println("wedingDate : "+wedingDate);//2016-07-17

        boolean after = localDate.isAfter(wedingDate);
        boolean before = localDate.isBefore(wedingDate);
        System.out.println("isAfter ? : "+after+" isBefore ? : "+before );
    }
}
