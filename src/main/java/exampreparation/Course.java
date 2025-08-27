package exampreparation;

public class Course {
    /*static*/ String name;
    //il faut mettre name en static ou bien enlever le static de la methode
    public /*static*/ void getName(){
        name = "Java";
        System.out.println(name);
    }

    public void getName(String name){
        this.name += name;
        System.out.println(name);
    }
}
class MyExamCloud {
    public static void main(String[] args) {
        var c = new Course();
        c.getName("Python");

        String quote = """
                sjvgnivbnoivnrovnrovnr.
                 vndevonovnvneovveezv. """;
    }
}
