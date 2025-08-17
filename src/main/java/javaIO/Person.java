package javaIO;

import java.io.Serializable;

/**
 * Marker interface Serializable pour marquer qu'un classe peut etre transformée en flux d'octet et inversement (deserialisation)
 * transient permet de marquer un champ comme non-serialisable
 * si on essaie de serialiser des champs d'une classe non serialisable, on utilise transient pour eviter une NotSerialisableException
 * Pour la persistance des objets (ORM)
 * ObjectInputStream
 */
public class Person implements Serializable {
    private String name, surname;
    private int age;
    private boolean isMarried;
    transient long personId;
    transient Weights weight;


    public Person(String name, String surname, int age, boolean isMarried, long personId, Weights weight) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isMarried = isMarried;
        this.personId = personId;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", personId=" + personId +
                ", weight=" + weight +
                '}';
    }
}
