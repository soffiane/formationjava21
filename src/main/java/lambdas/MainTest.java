package lambdas;

/**
 * Apprendre a ecrire une fonction avec l'interface Function
 */
public class MainTest {
    public static void main(String[] args) {
        //classe anonyme
        /*Animals animal = new Animals() {
            @Override
            public void show(String animal, int speed) {
                System.out.println(animal +" has a speed of "+speed);
            }
        };*/

        //labmda
        Animals animal = (animal1, speed) -> System.out.println(animal1 +" has a speed of "+speed);
        animal.show("Guepard",200);
    }
}
