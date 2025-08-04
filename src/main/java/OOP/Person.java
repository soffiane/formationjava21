package OOP;

/**
 * le constructeur permet d'initialiser l'objet
 * il est appelé a la creation de l'objet
 * on peut avoir un constructeur par defaut sans rien intialiser
 * constrcteur peut etre surchargé bien sur
 */
public class Person {

    private String name;
    private double weight;

    public Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(double weight) {
        this.weight = weight;
    }

    public Person(){};

    public void wakeUp(){
        System.out.println(this.name+" woke up");
    }

    public void eat(){
        System.out.println(this.name+" had breakfast");
        this.weight+=1;
    }

    public void doExercise(){
        System.out.println(this.name+" doing exercise");
        this.weight -= 1;
    }

    public void showWeight(){
        System.out.println(this.name+" weight is "+this.weight);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
