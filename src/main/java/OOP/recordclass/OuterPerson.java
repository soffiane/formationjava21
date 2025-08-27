package OOP.recordclass;

import java.io.Serializable;

public class OuterPerson {

    public static int age = 10;

    //nested record class is static
    static record InnerPerson(String name) implements Serializable {
        public void showAge(){
            //comme le record interne est static, on acced qu'a des trucs statique
            System.out.println("age = "+age);
        }
        public int getAge(){
            return age+1;
        }

        public void someMethod(){
            System.out.println("some method");
        }

        public static void test(){}

        static {
            System.out.println("toto");
        }
        record InnerRecord(){}
    }
}
