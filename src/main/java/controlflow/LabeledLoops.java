package controlflow;

/*
on peut labelisé les boucles pour faire des goto
pour les boucles imbriquées
 */
public class LabeledLoops {
    public static void main(String[] args) {
        String[] animals = {"Monkey","Bee","Cat","Dog","Cow"};
        int index = 0;
        String animal = "";
        animalsLoop:
        while(index < animals.length){
            animal = animals[index];
            if(animal == "Dog"){
                System.out.println(animal);
                break animalsLoop;
            }
            index++;
        }


        System.out.println("----------------- Unlabeled loop ------------------------");
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                System.out.println("Outer loop: "+i+", Inner loop; "+j);
                if(i==2 && j==2){
                    break;//on sort du premier for
                }
            }
        }

        System.out.println("----------------- Labeled loop ------------------------");
        outerloop:
        for(int i=1;i<=3;i++){
            innerloop:
            for(int j=1;j<=3;j++){
                System.out.println("Outer loop: "+i+", Inner loop; "+j);
                if(i==2 && j==2){
                    break outerloop;//on sort du double for
                }
            }
        }
    }
}
