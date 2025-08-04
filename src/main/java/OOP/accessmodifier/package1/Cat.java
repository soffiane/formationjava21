package OOP.accessmodifier.package1;

public class Cat {

    public static void main(String[] args) {
        Cat cat = new Cat();
        //on a acces a tous les modifiers dans la classe
        cat.publicMethod();
        cat.defaultMethod();
        cat.protectedMethod();
        cat.privateMethod();
    }

    private void privateMethod() {
        System.out.println("this is private modifier");
    }

    void defaultMethod() {
        System.out.println("this is default modifier");
    }

    protected void protectedMethod() {
        System.out.println("this is protected modifier");
    }

    public void publicMethod() {
        System.out.println("this is public modifier");
    }
}
