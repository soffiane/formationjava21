package OOP.interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.canEat();
        bird.canFly();

        Dog dog = new Dog();
        dog.canEat();
        dog.canFly();
    }
}
