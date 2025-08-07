package OOP.anonymousclass;

public class Cat implements Animals{
    @Override
    public void show(String name, int speed) {
        System.out.println("Im a "+name+" and run at "+speed+"km/h");
    }
}
