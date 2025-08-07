package OOP.polymorphism;

/**
 * Deux types de polymorphisme : statique et dynamique
 * dynamique : surcharge de methode
 */
class Vehicule{
    public void accelerate(){
        System.out.println("Vehicule accelerating");
    }
}
class Car extends Vehicule{
    @Override
    public void accelerate() {
        System.out.println("Car accelerating");
    }
}
class Motocycle extends Vehicule{
    @Override
    public void accelerate() {
        System.out.println("Motocycle accelerating");
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        //on peut declarer le type d'interface et l'instance de la classe heritée
        //polymorphisme - on peut substituer n'importe quel type de l'arbre d'heritage
        Vehicule vehicule = new Car();
        vehicule.accelerate();

        if(vehicule instanceof Car){
            Car car2 = (Car) vehicule;
            car2.accelerate();
        }

        Vehicule vehicule2 = new Motocycle();
        vehicule2.accelerate();

        //Car car = (Car) new Vehicule();//Class cast exception
        //on peut substituer une superclasse avec une classe qui en herite
        printAccelerate(new Motocycle());
        printAccelerate(new Car());


    }
    /* au lieu de faire ca pour chaque sous classe on peut ecrire une seule methode qui prend la superclasse en parametre
    public static void printAccelerate(Car car){
        car.accelerate();
    }

    public static void printAccelerate(Motocycle motocycle){
        motocycle.accelerate();
    }*/
    public static void printAccelerate(Vehicule vehicule){
        vehicule.accelerate();
    }

}
