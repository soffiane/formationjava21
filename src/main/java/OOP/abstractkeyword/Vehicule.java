package OOP.abstractkeyword;

public abstract class Vehicule {

    String type;
    String model;

    public Vehicule() {
    }

    public Vehicule(String type, String model) {
        this.type = type;
        this.model = model;
    }

    public void start(){
        System.out.println("Vehicule start");
    }

    public void stop(){
        System.out.println("Vehicule stops");
    }

    abstract int getMaxSpeed();

    //une classe abstraite peut avoir des methodes static
    public static void printHello(){
        System.out.println("Hello");
    }
}
