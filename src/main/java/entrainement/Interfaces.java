package entrainement;

public interface Interfaces {
    int q = 50;
    final String NAME = "JAVA 21"; //line 2

    public static int pass(int score) { //line 3
        return score;
    }

    public default String type(String type) { //line 4
        return type;
    }

    public boolean toto(boolean toto);

    //les interfaces ne peuvent pas avoir de methodes non static ou non default avec une implementation
//    public boolean isActive(boolean isActive) { //line 5
//        return isActive;
//    }
}

interface Go {
    public default int speed(int speed) {
        return speed;
    }
} //line 1

//Car.java in package “exam”
class Car implements Go {
    public String speed(String s) {
        return "50";
    } //line 2

    //il s'agit de la methode surchargee depuis l'interface Go, meme signature : speed(int ...) donc soit on change le type de retour soit on change dans l'interface
//    public String speed(int i) {
//        return "70";
//    } //line 3

    public static void main(String[] args) {
        System.out.println(new Car().speed(150));
    }
}
