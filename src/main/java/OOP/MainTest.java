package OOP;

public class MainTest {
    public static void main(String[] args) {
        Person person = new Person("David",60);
        person.wakeUp();
        person.eat();
        person.showWeight();
        person.doExercise();
        person.showWeight();
        //appel implicite a la methode toString
        System.out.println(person);
    }
}
