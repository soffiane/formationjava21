package OOP.recordclass;

/*
la classe Person va automatiquement avoir :
constructeur avec parametres
getter methods
toString, hashCode, equals

On met les parentheses apres le nom de la classe
public par defaut, pas de protected ou private autorisé

Classe immutable -> final implicite
field private final

une nested record classe est static implicitement
on peut ecrire des methodes dans une record classe mais pas des variables
on ne peut pas ecrire un parametre par defaut
compact canonical constructeur
pas de classe abstract
herite de la classe Record
pas de extends possible mais peut etendre une interface
 */
public record Person(String name, int age) implements Drink{

    //compact constructor - pas de parentheses
    /*public Person {
        this(null,0);
    }*/

    public Person{
        if(age < 0){
            System.out.println("age cannot be negative");
        }
    }

    //canonical constructor
    /*public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }*/

    @Override
    public void canDrink(String drinkName) {
        System.out.println("glouglou "+drinkName);
    }
    //static final int age = 10;

    public String isAdult(){
        return age > 18 ? "you are an adult" : " you are not an adult";
    }
}
