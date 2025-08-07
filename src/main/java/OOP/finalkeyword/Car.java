package OOP.finalkeyword;

public class Car extends Vehicle{

    public Car(String model){
        //on peut pas assigner une valeur a une variable final (constante)
        //this.model = model;
    }

    @Override
    public void showMaxSpeed(){
        System.out.println("Max speed of vehicule is 320");
    }
}
