package java21NewsOverview;

public class RecordPattern {
    public static void main(String[] args) {
        //Record Pattern (JEP 440)
        //On peut deconstruire un record et acceder a ses attributs
        Object o = new Object();
        if(o instanceof Point(int a, int b)){
            int c = a + b;
        }
        String s = "Hello World";
        if(s instanceof String sout){
            System.out.println(sout);
        }
        
        //possible dans un switch
        int value = switch(o){
            case Point(int i,int j) -> i+j;
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };

    }
}
record Point(int x, int y) {}