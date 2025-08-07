package OOP.encapsulation;

public class Encapsulationtest {
    public static void main(String[] args) {
        Car car = new Car("Ferrari",380,true);
        System.out.println(car.isAutomatic());
        System.out.println(car.getModel());
        System.out.println(car.getMaxSpeed());
        car.setAutomatic(false);
        System.out.println(car.isAutomatic());
        System.out.println(car.getModel());
        System.out.println(car.getMaxSpeed());
    }
}
