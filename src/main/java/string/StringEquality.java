package string;

import java.util.Arrays;

public class StringEquality {
    public static void main(String[] args) {
        /**
         * Egalité entre les String : method equals vs ==
         * String pool in heap memory -> String cree en literal :
         * ex String s1 = "Java" -> crée dans le String pool du heap memory
         * String s2 = "Java" -> pointe sur la meme adresse dans le String pool que s1
         * String cree avec le new cree un String Object dans la heap et aussi dans la String Pool (donc la reference + le pool sauf si existe deja)
         * String s4 = new String("Hello");
         * litteral != new
         */

        String s1 = new String("Hello World");
        String s2 = new String("Hello World");
        String s3 = "Hello World";
        String s4 = "Hello World";
        String s5 = "Hello"+ " World";
        System.out.println("----------------------------- == operator -------------------------------");
        System.out.println(s1 == s2);//false deux objets differents dans la heap
        System.out.println(s1 == s3);//false deux objets differents
        System.out.println(s1 == s4);//false deux objets differents
        System.out.println(s1 == s5);//false deux objets differents
        System.out.println(s2 == s3);//false deux objets differents
        System.out.println(s2 == s4);//false deux objets differents
        System.out.println(s2 == s5);//false deux objets differents
        System.out.println(s3 == s4);//true car same objet dans string pool
        System.out.println(s3 == s5);//true car same objet dans string pool
        System.out.println(s4 == s5);//true car same objet dans string pool

        System.out.println("ID of s1 "+System.identityHashCode(s1));
        System.out.println("ID of s2 "+System.identityHashCode(s2));
        System.out.println("ID of s3 "+System.identityHashCode(s3));
        System.out.println("ID of s4 "+System.identityHashCode(s4));
        System.out.println("ID of s5 "+System.identityHashCode(s5));//s3 s4 et s5 ont les memes id donc ils sont les memes dans la String pool

        System.out.println("----------------------------- equals() -------------------------------");
        //equals compare le contenu du string
        System.out.println(s1.equals(s2));//true car meme valeur
        System.out.println(s1.equals(s3));//true car meme valeur
        System.out.println(s1.equals(s4));//true car meme valeur
        System.out.println(s1.equals(s5));//true car meme valeur
        System.out.println(s2.equals(s3));//true car meme valeur
        System.out.println(s2.equals(s4));//true car meme valeur
        System.out.println(s2.equals(s5));//true car meme valeur
        System.out.println(s3.equals(s4));//true car meme valeur
        System.out.println(s3.equals(s5));//true car meme valeur
        System.out.println(s4.equals(s5));//true car meme valeur

        //Wrapper and primitives
        /*Integer age1 = 20;
        int age2 = 20;
        System.out.println(age1 == age2);//true
        System.out.println(age1.equals(age2));//true
        */

        String[] animals = new String[]{"Dog","Cat","Dog"};
        String[] animals2 = new String[]{"Dog","Cat","Cow"};
        String[] animals3 = new String[3];
        animals3[0] = "Dog";
        animals3[1] = "Cat";
        animals3[2] = "Cow";
        String[] animals4 = animals;

        System.out.println("---------------------- == operator -----------------------------");
        System.out.println(animals == animals2);//deux objets differents avec new -> false
        System.out.println(animals == animals3);//deux objets differents avec new -> false
        System.out.println(animals == animals4);//true car on a assigné animal4 avec l'adresse d'animals
        System.out.println(animals2 == animals3);//deux objets differents avec new -> false
        System.out.println(animals2 == animals4);//deux objets differents avec new -> false
        System.out.println(animals3 == animals4);//deux objets differents avec new -> false

        System.out.println("---------------------- equals() -----------------------------");
        //le equals de la classe Object appelle l'operateur == donc meme resultat equals() et ==
        System.out.println(animals.equals(animals2));
        System.out.println(animals.equals(animals3));//deux objets differents avec new -> false
        System.out.println(animals.equals(animals4));//true car on a assigné animal4 avec l'adresse d'animals
        System.out.println(animals2.equals(animals3));//deux objets differents avec new -> false
        System.out.println(animals2.equals(animals4));//deux objets differents avec new -> false
        System.out.println(animals3.equals(animals4));//deux objets differents avec new -> false

        //la classe Arrays a sa propre methode equals qui va matcher les elements des tableaux (ce qu'on veut en vrai)
        System.out.println("---------------------- Arrays.equals() -----------------------------");
        System.out.println(Arrays.equals(animals,animals2));
        System.out.println(Arrays.equals(animals,animals3));
        System.out.println(Arrays.equals(animals,animals4));
        System.out.println(Arrays.equals(animals2,animals3));
        System.out.println(Arrays.equals(animals2,animals4));
        System.out.println(Arrays.equals(animals3,animals4));

    }
}
