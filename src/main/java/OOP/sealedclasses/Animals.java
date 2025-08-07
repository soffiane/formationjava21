package OOP.sealedclasses;

/**
 * Vient de Java 15
 * La classe sealed definit quelle classe peut l'implementer ou l'heriter
 * pour eviter que la classe ne soit etendues par n'importe quelle classe
 * permits defini la liste des classes qui peuvent heriter cette classe
 * declaration d'une sealed class : sealed class Animals permits Dog, Cat, Bird
 * Une classe qui est dans la liste de la superclasse doit etre elle-meme sealed ou final
 * Logique pour eviter le multi level inheritence
 */
public sealed class Animals permits Dog, Cat, Bird{
}
