package controlflow;

/*
break : termine la boucle ou le switch
continue : continue la boucle
return : sort de la methode en cours et on retourne a l'appel de la methode
Le break et le continue ne sont utilisable que dans une boucle
Le return peut etre utilisé partout
 */
public class ReturnStatement {
    public static void main(String[] args) {
        int k = 1;
        switch (k){
            case 1:
                System.out.println("k is 1");
                break;//sort du switch
            case 2:
                System.out.println("k is 2");
                return;//sors du main
        }
        //si k = 2 on passe pas ici
        System.out.println("outside");

        String[] cars = {"BMW","Toyota","Ferrari","Mercedes","Ford"};
        for(String car : cars){
            if(car == "Mercedes"){
                return;//on sort du main()
            }
            System.out.println(car);
        }
        //on y va jamais mais c'est pas du unreachable code
        System.out.println("Not executed");
    }
}
