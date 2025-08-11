package string;

/**
 * Un objet immutable ne peut pas changer en lui meme mais on peut changer son adresse(reference)
 * String est immutable
 * Quand on modifie un String en verité on en crée un nouveau
 */
public class ImmutableString {
    public static void main(String[] args) {
        String message = "Hello";
        message.concat(" World");
        System.out.println(message);//affiche Hello car message est immutable
        String message2 = message.concat(" World");
        System.out.println(message2);//affiche HelloWorld
        System.out.println(System.identityHashCode(message));
        System.out.println(System.identityHashCode(message2));//deux adresse differentes

        String s = "android";
        s.toUpperCase();
        System.out.println(s);//affiche android car s est immutable
        String upperCase = s.toUpperCase();//on doit le transmettre dans un nouvel objet
        System.out.println(upperCase);

    }
}
