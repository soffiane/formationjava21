package OOP.accessmodifier.package2;

import OOP.accessmodifier.package1.Cat;

public class Bee {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.publicMethod();
        //on a pas acces a default et protected une fois sortie du package1
            /*cat.defaultMethod();
            cat.protectedMethod();
            cat.privateMethod();*/
    }
}
