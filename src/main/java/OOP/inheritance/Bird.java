package OOP.inheritance;

public class Bird extends Animals {

    boolean canFly = true;

    public Bird(){
        //on appelle le constructeur de la super classe Animals
        super();
        //on assigne la valeur de la super classe
    }
    public Bird(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public void fly() {
        System.out.println("Bird fly");
        //la variable de la classe Bird
        System.out.println("Can bird fly ? "+canFly);
        //super fait reference a la superclasse ANimals
        System.out.println("Animals can fly ? "+super.canFly);
    }

    @Override
    public void printLegs(String animals) {
        this.fly();
        //super permet d'appeler la methode de la superclasse
        super.printLegs(animals);
    }

    @Override
    public void drink(String animals) {
        System.out.println("Bird drink at fountain");
    }

    @Override
    void move(String animals) {
        System.out.println("Brid can also fly");
    }

    @Override
    public void breath(String animals) {
        System.out.println("Bird is singing");
    }
}
