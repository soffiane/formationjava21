package string;

/**
 * pas besoin d'importer les classes de java.lang car importées automatiquement
 *
 *              String      vs StringBuffer vs StringBuilder
 * Storage area String pool vs Heap         vs heap
 * Modifiable   Immutable   vs Mutable      vs Mutable
 * Performance  Fast        vs Slow         vs Fast
 */
public class Strings {
    public static void main(String[] args) {
        //String est une chaine de caracteres
        //c'est comme un tableau de string dont chaque caractere a un indice dans le tableau

        String s1 = "Java";//'j' est a l'indice 0 'a' à l'indice 1 etc...
        //on peut instancier un String via new
        String s2 = new String("World");

        //string concatenation with +
        System.out.println(s1+" "+s2);

        String s3 = s1 +" "+ s2;
        System.out.println(s3);
        System.out.println(4 + 5 + "6");//fait 4+5 et ajoute le string 6 donc 96
        System.out.println("4" + 5 + 6);//comme on a mis le string en premier tout devient un string -> 456
        System.out.println(4 + "5" + 6);//affiche les string 456 car aucun addition int faite ici


    }
}
