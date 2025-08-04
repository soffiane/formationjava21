package OOP;

/**
 * Stack : memoire au run time : variable locales, methodes, object references : LIFO -> StackoverFlow : duree de l'execution de la fonction
 * Heap : variables d'instances (static), object et references de types -> OutOfMemoryError : duree d'execution du programme
 * Pas besoin de gerer manuellement la memoire comme en C++ -> garbage collector (les 3 zones de la GCen fct de lage de l'objet)
 * Quand on cree un objet, l'objet est dans la heap et son adresse dans la stack
 */
public class StackAndHeap {
    Cat myPet = new Cat();//l'adresse de myPet va dans la stack
}
//la classe va dans la heap
class Dog{
    //variable de classe dans la heap
    double height;
    double weight;
}

//la classe va dans la heap
class Cat{
    //l'instance de Dog va dans la heap
    Dog dog = new Dog();
    String color;
}
