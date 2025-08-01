package controlflow;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a day num of week");
        int dayNumber = scanner.nextInt();
        String day;

        /*switch (dayNumber) {
            case 1:
                day = "Monday";
                //le break permet de sortir du switch, si on le met pas on execute le case suivant
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                day = "Unknown";
                break;
        }*/

        switch(dayNumber){
            //on peut imbriquer plusieurs case qui reponde a un critere
            case 1: case 2: case 3 : case 4: case 5:
                day = "Weekday";
                break;
            case 6: case 7:
                day = "Weekend";
                break;
            default:
                day = "Invalid";
                break;


        }

        /* enhanced switch
        String day = switch (dayNumber) {
            case 1 -> "Monday";
            //le break permet de sortir du switch, si on le met pas on execute le case suivant
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Unknown";
        };*/

        scanner.close();

        System.out.println("Today is : " + day);
    }
}
