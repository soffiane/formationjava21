package OOP.inheritance;

/**
 * Pas d'heritage multiple en java
 *  On herite des attributs et methodes public et protected et des nested classes de la super classe
 *  Si super classe et sous classe sont dans le meme package, elle herite aussi des attributs package protected (pas les attributs private)
 *
 *  Methode override : on peut changer la vaisiblité des methodes surchargée dans les sous classes dans le sens du moins restrictif
 *  en gros on peut augmenter les privileges mais pas les diminuer
 *
 *  le mot clé "this" permet d'acceder a une methode ou une variable de la classe dans laquelle il est utilisé : c'est une reference a l'instance de la classe
 *  il permet aussi de lever les ambiguites quand les parametres et les attributs ont le meme nom (dans le constructeur par exemple) sinon le compileur ajoute automatiquement "this" la ou il faut
 *  on peut pas utiliser "this" dans un contexte statique car pas d'instance
 */
public class TestInheritence {

    public static void main(String[] args) {
        //Dog a acces aux methodes public et protected de la superclasse Animals
        Dog dog = new Dog(4);
        //methode privee dans la superclasse = pas acces
        //dog.eat();
        dog.bark();
        dog.drink("Dog");
        dog.breath("Dog");
        dog.move("Dog");
        //on accede a la variable de la superclasse Animals
        dog.printLegs("Dog");

        Bird bird = new Bird(2);
        bird.breath("Bird");
        bird.drink("Bird");
        bird.move("Bird");
        bird.fly();
        bird.printLegs("Bird");

        Dog dog2 = new Dog();
        dog2.bark();
        dog2.drink("Dog");
        dog2.breath("Dog");
        dog2.move("Dog");
        //constructeur par defaut ici donc 45 jambes
        dog2.printLegs("Dog");
    }
}
