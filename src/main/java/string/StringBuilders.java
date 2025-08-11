package string;

/**
 * Comme StringBuffer mais pas Thread safe donc plus rapide que StringBuffer
 * StringBuffer est Thread Safe
 * Meme methodes que StringBuffers
 */
public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Hello");
        builder.append(" World");
        System.out.println(builder);//affiche Hello World, marche car mutable
        System.out.println(builder.length());
        System.out.println(builder.insert(builder.length()," !"));
        System.out.println(builder.length());
        System.out.println(builder.reverse());//inverse les caracteres (lol)
        System.out.println(builder.delete(0,4));
    }
}
