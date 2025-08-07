package OOP.encapsulation;

public class Car extends Vehicule{

    private boolean isAutomatic;

    public Car(String model, int maxSpeed, boolean isAutomatic) {
        //super doit toujours etre appele en premier si utilisé
        super(model, maxSpeed);
        this.isAutomatic = isAutomatic;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isAutomatic=" + isAutomatic +
                "} " + super.toString();
    }
}
