package DateTimeAPI;

import java.time.LocalTime;

/**
 * LocalTime est IMMUTABLE et represente une heure en general heure-minute-seconde
 * ne tient pas compte des offset ou des timezones
 * Pas de constructeur et est final : methodes statiques
 */
public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime : "+localTime);//16:09:34.164048600

        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        int nano = localTime.getNano();

        System.out.println("hour : "+hour);
        System.out.println("minute : "+minute);
        System.out.println("second : "+second);
        System.out.println("nano : "+nano);

        LocalTime twoHoursAgo = localTime.minusHours(2);
        System.out.println("twoHoursAgo : "+twoHoursAgo);

        LocalTime thirtyMinutesLater = localTime.plusMinutes(30);
        System.out.println("thirtyMinutesLater : "+thirtyMinutesLater);

        //LocalTime is immutable
        System.out.println("localTime : "+localTime);//16:09:34.164048600

        LocalTime localTime1 = LocalTime.of(15, 0, 1);
        System.out.println("localTime1 : "+localTime1);

        boolean after = localTime.isAfter(localTime1);
        boolean before = localTime.isBefore(localTime1);
        System.out.println("is after ? : "+after+" is before ? : "+before);
    }
}
