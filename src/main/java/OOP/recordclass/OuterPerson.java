package OOP.recordclass;

public class OuterPerson {

    public static int age = 10;

    //nested record class is static
    static record InnerPerson(String name){
        public void showAge(){
            //comme le record interne est static, on acced qu'a des trucs statique
            System.out.println("age = "+age);
        }
    }
}
