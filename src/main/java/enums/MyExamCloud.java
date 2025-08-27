package enums;

import java.util.Arrays;

public class MyExamCloud {
    public enum AI_MODELS {
        ML('A'),SL('B'),UL('C'), DL('D');
        char c;
        private AI_MODELS(char c){
            this.c = c;
        }
    }

    public static void main(String[] args) {
        //le resultat du drop est ignoré
        Arrays.stream(AI_MODELS.values()).dropWhile(s -> s.equals(AI_MODELS.SL));
        switch (AI_MODELS.valueOf("SL")){
            case ML -> System.out.println("Machine learning");
            case SL -> System.out.println("Supervised learning");
            case UL -> System.out.println("Unsupervised learning");
            case DL -> System.out.println("Deep learning");
            default -> System.out.println("Undefined ai model");
        }
    }
}
