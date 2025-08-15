package DateTimeAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar est une classe abstraite MUTABLE
 */

public class ClassCalenderExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM YYYY hh:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yy hh:mm");

        System.out.println("currentYear : "+year);
        System.out.println("currentMonth : "+month);//les mois de l'année vont de 0 a 11
        System.out.println("currentWeekOfYear : "+weekOfYear);
        System.out.println("currentweekOfMonth : "+weekOfMonth);
        System.out.println("currentdayOfYear : "+dayOfYear);
        System.out.println("currentdayOfMonth : "+dayOfMonth);
        System.out.println("currentdayOfWeek : "+dayOfWeek);
        System.out.println("currentdayOfWeekInMonth : "+dayOfWeekInMonth);

        int hour = calendar.get(Calendar.HOUR);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        Date dateTime = calendar.getTime();
        String dateTimeFormatted = simpleDateFormat.format(dateTime);
        String dateTimeFormatted2 = simpleDateFormat2.format(dateTime);

        System.out.println("hour : "+hour);//0 pour midi - 0 - 11
        System.out.println("hourOfDay : "+hourOfDay);//12 pour 12 - 0 - 23
        System.out.println("minute : "+minute);
        System.out.println("second : "+second);
        System.out.println("millisecond : "+millisecond);
        System.out.println("dateTime : "+ dateTime);//Fri Aug 15 12:20:42 CEST 2025
        System.out.println("dateTimeFormatted : "+ dateTimeFormatted);//15 août 2025 12:20:42
        System.out.println("dateTimeFormatted2 : "+ dateTimeFormatted2);//15-08-25 12:22

        Calendar birthday = Calendar.getInstance();
        birthday.set(1986,Calendar.MAY,21);
        System.out.println("birthday : "+birthday.getTime());

        //Time travel
        birthday.add(Calendar.YEAR,10);
        System.out.println("birthday future : "+birthday.getTime());
    }
}
