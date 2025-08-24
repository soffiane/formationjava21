package exampreparation;

import java.io.Serializable;

/**
 * On peut avoir des methodes privées dans une interface mais elle ne seront pas disponible pour les classes filles
 * les methodes sont publiques par defaut
 * Une interface peut etendre plusieurs classes
 */
public interface Interfaces extends Serializable,Runnable{
    //pas besoin de surcharger les methodes default
    default void toto(){
        System.out.println("toto");
    }

    //pas besoin de surcharger les methodes static
    private static void hello() {
        System.out.println("hello");
    }

    private void gg(){
        System.out.println("gg");
        //methode privée statique
        hello();
    }

    public abstract void noob();
}

class Toto implements Interfaces{

    @Override
    public void noob() {
        System.out.println("Doit etre surchargées");
    }

    @Override
    public void run() {

    }
}

class Main2 {
    public static void main(String[] args) {
        Interfaces toto = new Toto();
    }
}
