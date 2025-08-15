package DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Sert a formatter des dates
 * IMMUTABLE et THREAD-SAFE
 * Soit avec des patterns
 * Soit avec les constantes predefinies : ex ISO_LOCAL_DATE
 * Voir la JAVADOC
 */
public class DateTimeFormattingExamples {
    public static void main(String[] args) {
        //String pattern
        LocalDate customDate = LocalDate.of(2030,6,7);
        LocalTime customTime = LocalTime.of(11,20,30);
        LocalDateTime customDateTime = LocalDateTime.of(customDate,customTime);
        System.out.println("affichage par defaut datetime : "+customDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM-dd-yyyy hh:mm:ss");
        System.out.println("affichage formatté : "+dateTimeFormatter.format(customDateTime));//juin-07-2030 11:20:30

        //Avec les constantes predefinies
        DateTimeFormatter dateTimeFormatterIso = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println("affichage formatté ISO : "+dateTimeFormatterIso.format(customDateTime));//20300607

        DateTimeFormatter dateTimeFormatterIsoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("affichage formatté ISODATETIME : "+dateTimeFormatterIsoDateTime.format(customDateTime));//2030-06-07T11:20:30


        DateTimeFormatter localizedFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("localizedFormatter MEDIUM : "+localizedFormatter.format(customDateTime));//7 juin 2030, 11:20:30
    }
}
