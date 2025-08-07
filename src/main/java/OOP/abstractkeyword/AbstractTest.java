package OOP.abstractkeyword;

/**
 * Une classe abstraite ne peut pas etre instanciée
 * Si une classe contient une methode abstraite, elle doit etre abstraite
 * les methodes abstraites n'ont pas d'implementation
 * on ne peut pas utiliser abstract sur les variables
 * Une methode abstract ne peut pas etre final ou private (logique) ni etre static
 * A quoi ca sert en Java ?
 * When we talk about abstract classes we are defining characteristics of an object type; specifying what an object is.
 * When we talk about an interface and define capabilities that we promise to provide, we are talking about establishing a contract about what the object can do.
 */
public class AbstractTest {
    public static void main(String[] args) {
        Car car = new Car("Car","Ferrari");
        car.start();
        car.stop();
        car.getMaxSpeed();

        /*Vehicule vehicule = new Vehicule() {
            @Override
            int getMaxSpeed() {
                return 0;
            }
        }*/
    }
}
