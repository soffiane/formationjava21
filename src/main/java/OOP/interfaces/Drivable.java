package OOP.interfaces;

/**
 * Une interface permet de partager des comportements en commun
 * mot clé "implements"
 * Une classe qui herite d'une interface DOIT IMPLEMENTER les methodes de l'interface
 * Une classe peut implementer plusieurs interfaces
 * Une interface ne peut avoir que des CONSTANTES et des signatures de methodes
 * On ne peut pas instancier une interface, pas de constructeurs
 * Une interface peut heriter d'une autre interface
 * Interface "je peux faire des choses" mais ne sait pas comment
 * les methodes des interfaces sont PUBLIC par defaut
 * ABSTRACTION
 */
// public interface et pas interface public
interface CanEat {
    void canEat();

    //mot cle default pour definir une methode par defaut AVEC une implementation
    //les classes qui implemente l'interface ne sont pas obligé de l'implementer
    default void canDrink(){
        System.out.println("You can drink");
    }
    //on peut aussi avec des methodes statique AVEC une implementation
    //les classes qui implemente l'interface ne sont pas obligé de l'implementer
    public static int getAge(){
        return 5;
    }
}

interface CanFly {
    void canFly();
}

class Dog implements CanEat,CanFly{

    @Override
    public void canFly() {
        System.out.println("Dog cant fly");
    }

    @Override
    public void canEat() {
        System.out.println("Dog can eat");
    }
}

class Bird implements CanEat, CanFly{

    @Override
    public void canEat() {
        System.out.println("Bird can eat");
    }

    @Override
    public void canFly() {
        System.out.println("Bird can fly");
    }
}
