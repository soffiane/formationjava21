package string;

/**
 * StringBuffer est un String modifiable
 * StringBuffer est synchronized (thread safe)
 */
public class StringBuffers {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello");
        buffer.append(" World");
        System.out.println(buffer);//affiche Hello World, marche car mutable
        System.out.println(buffer.length());
        System.out.println(buffer.insert(buffer.length()," !"));
        System.out.println(buffer.length());
        System.out.println(buffer.reverse());//inverse les caracteres (lol)
        System.out.println(buffer.delete(0,4));
    }
}
