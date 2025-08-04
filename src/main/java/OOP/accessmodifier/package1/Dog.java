package OOP.accessmodifier.package1;

public class Dog {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.publicMethod();
        cat.defaultMethod();
        cat.protectedMethod();
        //on a pas acces a la methode privée definie dans Cat
        //cat.privateMethod();
    }
}
