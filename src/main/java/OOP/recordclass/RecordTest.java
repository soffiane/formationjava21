package OOP.recordclass;

/**
 * Record classes : introduit dans Java , stabilisé dans Java 16
 * permet de creer des conteneurs de données immutables
 * contient uniquement des données et des accesseurs
 * genere automatiquement equals,toString et hashcode
 * avant on avait les POJO, maintenant on a les record classes
 * equivalent data classes dans Kotlin
 * etait disponible avec Lombok mais maintenant natif dans API Java
 *
 * Record classe = POJO fait avec Lombok SANS les setters (car Record est immutable)
 */
public class RecordTest {
    public static void main(String[] args) {
        //pojo class
        PersonPojo personPojo = new PersonPojo("Soffiane",39);
        System.out.println("Name "+personPojo.getName());
        System.out.println("Age "+personPojo.getAge());
        System.out.println(personPojo);

        PersonPojo personPojo1 = new PersonPojo("Soffiane",39);
        System.out.println("same persons ? "+personPojo1.equals(personPojo));
        //same hashcode - 2 objet equals ont forcement le meme hashcode mais l'inverse n'est pas vrai
        System.out.println("Hash of personPojo "+personPojo.hashCode());
        System.out.println("Hash of personPojo2 "+personPojo1.hashCode());

        //record class
        Person person = new Person("Soffiane",39);
        System.out.println("Name "+person.name());
        System.out.println("Age "+person.age());
        System.out.println(person);

        Person person2 = new Person("Soffiane",39);
        System.out.println("Name "+person2.name());
        System.out.println("Age "+person2.age());
        System.out.println(person2);

        System.out.println("Hash of personPojo "+person.hashCode());
        System.out.println("Hash of personPojo2 "+person2.hashCode());

        Person p2 = new Person("Paul",-5);
        System.out.println(p2.isAdult());
        OuterPerson.InnerPerson innerPerson = new OuterPerson.InnerPerson("toto");
        innerPerson.showAge();
        System.out.println(innerPerson.name());
    }
}
