package OOP.statique;

public class Car {

    public static int currentSpeed = 0;
    public static int maxSpeed = 180;
    public String brand;

    public static void showCurrentSpeed(int speed){
        System.out.println("Your current speed is "+speed);
    }

    public static void speedUp(int increase){
        currentSpeed += increase;
        //on ne peut pas utiliser une variable non static dans un contexte static
        //brand = "toto";
        if(currentSpeed > maxSpeed){
            showCurrentSpeed(currentSpeed);
            System.out.println("Slow down !");
        } else {
            showCurrentSpeed(currentSpeed);
        }

    }

    public static void speedDown(int decrease){
        currentSpeed -= decrease;
        showCurrentSpeed(currentSpeed);
    }

    public static void stop(){
        currentSpeed = 0;
        showCurrentSpeed(currentSpeed);
    }
}
