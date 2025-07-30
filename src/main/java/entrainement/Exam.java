package entrainement;

/* byte, short,int, long, float, double*/
public class Exam {
    static void display(int i) {System.out.print("1");}
    static void display(short s) {System.out.print("2");}
    static void display(double d) {System.out.print("3");}
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        long l = 3;
        int i = 3;
        float f = 1;
        double d = 2;
        display(b);//byte est converti en short, le plus proche --> 2
        display(s);//c'est un short --> 2
        display(l);//long est converti en double --> 3
        display(i);//int --> 1
        display(f);//float est converti en double --> 3
        display(d);//double --> 3
    }
}
