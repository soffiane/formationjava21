package lambdas;

/**
 * stable en java 14
 * nouveau keyword : yield : permet a un switch de renvoyer une valeur
 * Pattern matching : on peut utiliser instance of de maniere plus efficace
 *
 */
public class EnhancedSwitch {

    public static void main(String[] args) {
        int day = 3;
        //plus besoin des break avec cette syntaxe
        String dayName = switch (day){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> {
                System.out.println("Middweek day");
                yield "Wednesday";
            }
            default -> "Invalid day";
        };
        //ou aussi : avec yield
        String dayName2 = switch (day){
            case 1 : yield "Monday";
            case 2 : yield "Tuesday";
            case 3 : {
                System.out.println("Middweek day");
                yield "Wednesday";
            }
            default : yield "Invalid day";
        };
        System.out.println(dayName);

        //Pattern matching
        Object obj = 123;
        String result = switch (obj){
            case Integer i -> "Integer : "+i;
            case String s -> "String : "+s;
            default -> "Unknown type";
        };
        System.out.println(result);
        //ou encore
        String result3 = switch (obj){
            case Integer i : yield "Integer : "+i;
            case String s : yield "String : "+s;
            default : yield  "Unknown type";
        };

        //Enum
        Days day1 = Days.MONDAY;
        //le switch doit couvrir toutes les valeurs de l'enum ou bien comporter la clause default
        String message = switch (day1){
            case MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY -> "Workday";
            case SATURDAY,SUNDAY -> "Weekend";
            default -> "Invalid day";
        };

    }
}

enum Days {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}
