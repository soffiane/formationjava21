package OOP.statique;

//* import static : on importe des classes statiques et methodes dont on veut utiliser les methode comme la classe Math
/*import static OOP.statique.Employee.increaseSalary;
import static OOP.statique.Employee.showSalary;
import static OOP.statique.Employee.currentSalary;*/
import static OOP.statique.Employee.*;

/**
 * On peut declarer des variables des methodes et memes des classes static et des interfaces statiques depuis java8
 * variable : partagée entre toutes les instances de la classe : Classe.variable -> accessible directement sans passer par une instance
 * methode : comme variable Classe.methode(); -> les classes Utils
 * block : code executé quand la classe est chargée dans la JVM
 * nested class :
 * interface :
 *
 * Inconvenient du static : les methodes statiques ne peuvent pas acceder aux variables d'instance ou aux methodes non statiques.
 * Difference au niveau du polymorphisme
 * On ne peut pas mock dans methodes statiques dans des tests unitaires
 * methodes et variables statiques ne sont jamais GCed donc probleme de memoire potentiels
 *
 * import static : on importe des classes statiques dont on veut utiliser les methode comme la classe Math
 */
public class StaticKeyword {
    public static void main(String[] args) {
        Car.showCurrentSpeed(Car.currentSpeed);
        Car.speedUp(50);
        Car.speedUp(150);
        Car.speedDown(30);
        Car.stop();

        Car car = new Car();
        //on peut appeler une methode statique via une instance mais on a un warning
        car.showCurrentSpeed(car.currentSpeed);
        car.speedUp(50);
        car.showCurrentSpeed(car.currentSpeed);

        //avec import static on peut appeler directement la methode au lieu de faire Classe.methode
        showSalary(currentSalary);
        increaseSalary(1000);
    }
}
