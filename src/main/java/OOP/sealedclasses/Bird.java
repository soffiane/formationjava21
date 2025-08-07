package OOP.sealedclasses;

/**
 * final car on doit empecher que cette classe puisse etre heritée dans la logique du mecanisme du sealed
 */
public final class Bird extends Animals {

    public void fly(){
        System.out.println("Bird fly");
    }
}
