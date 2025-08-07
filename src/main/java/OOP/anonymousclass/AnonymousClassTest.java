package OOP.anonymousclass;

/**
 * classe anonyme = inner class sans nom
 * elle n'a pas acces aux variable local de son scope sauf final
 * elle a acces aux attributs de la classe qui la contient
 */
public class AnonymousClassTest {
    public static final String NOM = "toto";
    String test = "test";
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.show("cat",150);
        //declaration d'une classe anonyme a partir de l'interface Animals
        Animals animals = new Animals() {
            //pas de constructeur dans une classe anonyme
            //public Animals(String name){};
            //elle peut avoir des attributs a condition que ce soit des constantes
            static final String toto = "toto";
            public String titi;
            @Override
            public void show(String name, int speed) {
                System.out.println("Im a "+name+" and run at "+speed+"km/h"+toto+" "+titi);
            }
        };
        //meme chose mais avec le formalisme lambda depuis java 8
        //Animals animals = (name, speed) -> System.out.println("Name: "+name+" speed: "+speed+ " nom "+NOM);

        animals.show("Cheetah",90);
    }
}
