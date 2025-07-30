package controlflow;

public class TernaryOperator {

    public static void main(String[] args) {
        //Ternary operator
        int score = 40;
        String result;
        /*if(score > 50){
            result = "You passed";
        } else {
            result = "You failed";
        }*/
        result = score > 50 ? "You passed" : "You failed";
        System.out.println("result is : "+result);
    }
}
