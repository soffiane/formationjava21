package OOP.abstractkeyword;

/**
 * On doit override des methodes abstract et des constructeurs(sauf par defaut)
 */
public class Car extends Vehicule{

    public Car(String type, String model) {
        super(type, model);
    }

    @Override
    int getMaxSpeed() {
        final int MAX_CAR_SPEED = 320;
        System.out.println("Max speed of car is "+MAX_CAR_SPEED);
        return MAX_CAR_SPEED;
    }

    @Override
    public void start() {
        System.out.println("Car start");
    }

    @Override
    public void stop() {
        System.out.println("Car stop");
    }
}
