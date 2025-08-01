package controlflow;

public class ForLoop {
    public static void main(String[] args) {

        //on peut ecrire aussi ++i i+=1
        for(int i=0;i<=10;i++){
            System.out.println("i = :"+i);

        }

        for(int j=0;j<=10;){
            System.out.println("j = :"+j);
            //on peut incrementer dans la boucle
            j++;
        }

        int sum =0;
        for(int k=0;k<=10;k++){
            if(k % 2 == 0){
                System.out.println(k+" is odd");
                sum += k;
            }
        }
        System.out.println("sum of odd numbers is : "+sum);

        //boucle for avec deux variables - ici on sort quand a est >= 5, on va jamais atteindre b=11
        for(int a =0, b=1; a<=5 && b< 11;a++,b++){
            System.out.println("a: "+a);
            System.out.println("b: "+b);
            System.out.println("--------------");
        }
        //nested for
        int counter = 0;
        for(int x=1;x<4;x++){
            for(int y=0;y<=5;y++){
                System.out.println("x: "+x);
                System.out.println("y: "+y);
                System.out.println("counter :"+ ++counter);
                System.out.println("--------------");
            }
        }

        //boucle infinie
        /*for(;;){
            System.out.println("Hello World");
        }*/

        //for each loop pour iterer dans un tableau
        char[] letters = {'h','e','l','l','o'};
        //syntaxe classique
        /*
        for(int i =0; i< letters.length; i++){
            System.out.println(letters[i]);
        }
         */
        //for each
        for (char letter : letters) {
            System.out.println(letter);
        }

        int [] number = {1,2,3,4,5};
        int sum1=0;
        for(int num : number){
            sum1+=num;
        }
        System.out.println("sum is : "+sum1);

        //on peut utiliser sur un String qui est un tableau de chars
        String movie = "Titanic";
        for (char letter : movie.toCharArray()){
            System.out.print(letter);
        }
    }
}
