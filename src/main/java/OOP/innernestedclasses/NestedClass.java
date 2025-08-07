package OOP.innernestedclasses;

/**
 *                      Nested classes
 *    Static nested classes             non-static nested classes (inner classes)
 *                                 Local classes                    Anonymous classes
 */
public class NestedClass {

    static String person1 = "John";
    private static String person2 = "David";
    public String person3 = "Andy";

    //static nested class
    static class StaticPerson{
        void show(){
            System.out.println("Person1 "+person1);
            System.out.println("Person2 "+person2);
            //class statique n'accede pas aux variables non statiques de la classe englobante
            //System.out.println("Person3 "+person3);
        }
    }

    class Person{
        void show(){
            System.out.println("Person1 "+person1);
            System.out.println("Person2 "+person2);
            //inner class non static accede aux variable de classe
            System.out.println("Person3 "+person3);
        }
    }
}
