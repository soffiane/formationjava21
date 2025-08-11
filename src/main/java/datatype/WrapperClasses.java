package datatype;

/**
 * les wrapper classes sont l'equivalent en Objet des types primitifs
 * byte -> Byte
 * short -> Short
 * int -> Integer
 * long -> Long
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 * char -> Character
 * Utilisé pour les Collections List Queue Deque -> utilise uniquement les objets et pas les primitifs
 *
 * Conversion
 * primitif vers Wrapper
 * Wrapper vers primitif
 */
public class WrapperClasses {

    public static void main(String[] args) {
        //Conversion : primitif vers Wrapper
        //Via le constructeur mais deprecié depuis java 9
        //Integer firstInt = new Integer(20);

        //il vaut mieux passer par une methode static de la classe Wrapper
        Integer secondInt = Integer.valueOf(20);

        //recuperer le primitif depuis le wrapper
        int i = secondInt.intValue();

        //Autoboxing et unboxxing -> conversion auto entre primitif et wrapper
        //avant on ecriait  Integer secondInt = Integer.valueOf(20); et int i = secondInt.intValue();
        //auto boxxing
        Integer a = 5;
        //auto unboxxing
        int b = Integer.valueOf(5);
        int d = a;

        System.out.println(a+" "+d);

        Double dc = 12.8;//auto boxxing of double
        double c = dc;//auto unboxxing of Double

        System.out.println(dc+" "+c);

        Character character = 'b';//auto boxxing of double
        char ch = character;//auto unboxxing of Double

        System.out.println(character+" "+ch);

        //On peut mettre un Wrapper a null mais pas un primitif -> type missmatch error (on peut pas convertir null vers primitif)
        Integer integer = null;
        //si on cast ca compile mais runtime error
        //int int1 = (Integer)null;
        //int int2 = integer; //NPE
    }
}
