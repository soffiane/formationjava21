package lambdas;

/**
 * Une interface fonctionnelle est une interface avec une seule methode abstraite
 * avec l'annotation
 *
 * Concept de Marker Interface
 * Une interface avec 0 methodes ou champs dedans, comme Serializable par exemple (Cloneable, Remote)
 * Sert de marqueurs, une classe qui n'est pas marquée Serializable ne peut pas etre serialisée
 */
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
