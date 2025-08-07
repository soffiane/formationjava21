package OOP.inheritance;

public class Animals {

    public int numberOfLegs;

    public boolean canFly = false;

    public Animals(){

    }

    public void printLegs(String animals){
        System.out.println(animals+ " has "+this.numberOfLegs+" legs");
    }

    private void eat(String animals){
        System.out.println(animals+" eat foods");
    }

    protected void drink(String animals){
        System.out.println(animals+" drink water");
    }

    void move(String animals){
        System.out.println(animals+" move");
    }

    public void breath(String animals){
        System.out.println(animals+" breathe");
    }
}
