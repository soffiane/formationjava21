package OOP.innernestedclasses;

public class Users {

    static String person1 = "John";
    private static String person2 = "David";
    public String person3 = "Andy";

    class InnerClass{
        void show(){
            //la inner classe nest pas static donc on a acces aux variables d'instance
            System.out.println("Person1 "+person1);
            System.out.println("Person2 "+person2);
            System.out.println("Person3 "+person3);
        }
    }
}
