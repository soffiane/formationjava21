package OOP.inheritance;

public class Dog extends Animals{

    public Dog(){
        //on appelle le constructeur avec this
        //utilisable comme ca juste dans les constructeurs
        this(45);
    }

    public Dog(int numberOfLegs){
        this.numberOfLegs = numberOfLegs;
    }
    public void bark(){
        System.out.println("Dog bark");
    }

    @Override
    public void printLegs(String animals) {
       super.printLegs(animals);
    }

    @Override
    protected void drink(String animals) {
        System.out.println("Dog is thirsy");
    }

    @Override
    void move(String animals) {
        System.out.println("Dog is happy");
    }

    @Override
    public void breath(String animals) {
        System.out.println("Dog is breathing heavily");
    }
}
