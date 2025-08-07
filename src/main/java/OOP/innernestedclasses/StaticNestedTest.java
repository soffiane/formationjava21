package OOP.innernestedclasses;

import OOP.innernestedclasses.NestedClass.StaticPerson;
import OOP.innernestedclasses.Users.InnerClass;

public class StaticNestedTest {
    public static void main(String[] args) {
        //comment on instancie une nested classe : on passe par la classe englobante
        /*NestedClass.StaticPerson staticPerson = new NestedClass.StaticPerson();
        staticPerson.show();*/
        //autre option : on importe la classe nested
        StaticPerson staticPerson = new StaticPerson();

        //comme la classe interne n'est pas statique on doit passer par une instance pour y acceder
        //Users.InnerClass users = new Users.InnerClass(); --> KO
        Users outer = new Users();
        //Users.InnerClass inner = outer.new InnerClass();
        //ou encore avec les impors
        InnerClass inner = outer.new InnerClass();
        inner.show();

    }
}
