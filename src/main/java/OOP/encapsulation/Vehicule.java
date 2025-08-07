package OOP.encapsulation;

/**
 * Principe d'encapsulation : les variables de la classes sont privées et on y accede via des getters/setters public
 */
public class Vehicule {

    private String model;
    private int maxSpeed;

    public Vehicule(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
