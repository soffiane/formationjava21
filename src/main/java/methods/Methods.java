package methods;
/*
public private protected : access modifiers
static final :
type de retour puis nom de la methode
On peut inverser la place d l'access modifiers et
nom valides de methode : avec _ ou $ au debut
 */
public class Methods {
    /*
    args = var args : String[] ou String... pour faire varier le nombre de parametres
     */
    public static void main(String[] args) {
        System.out.println(addNumbers(10,20));
        System.out.println(addNumbers(10,20,30,40,50));
    }

    void start(){

    }

    double start2(){
        return 0.0;
    }

    public static void test(){

    }

    public static int min(int a, int b){
        return Math.min(a,b);
    }

    //changer le type de retour ne suffit pas, il faut aussi changer les parametres
    public static int addNumbers(int a, int b){
        return a+b;
    }
    public static double addNumbers(int a, double b){
        return a+b;
    }

    //var args - eviter d'avoir plusieurs var args dans une methode et on met le dernier param
    public static int addNumbers(int... args){
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    //method overloading
    //methode meme nom mais avec des parametres differents
    int addNumbers(int x,int y, int z){
        return x+y+z;
    }
}
