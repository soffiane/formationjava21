package exampreparation;

/**
 * Record class on peut declarer un constructeur : canonical (avec param) et compact (sans param)
 * On a pas besoin du mot clé class pour definir une record class
 * Un record class genere automatiquement les constructeur et les getter setter, equals() et hashCOde() et toString()
 * @param name
 * @param age
 */
public record Student(String name, int age){//et pas record class Student
    public Student {
        System.out.println("Creating student : "+name);
    }
}

class Main{
    public static void main(String[] args) {
        Student s = new Student("John",20);
    }
}
