package OOP.finalkeyword;

/**
 * Une classe final ne peut pas etre heritée
 * Une methode final ne peut pas etre override
 * Une variable final ne peut pas changer de valeur
 */
public class Vehicle {

    String model = "";
    //convention de definition d'une constante
    public static final int NUMBER = 10;

    public void showMaxSpeed(){
        System.out.println("Max speed of vehicule is 180");
    }
}
