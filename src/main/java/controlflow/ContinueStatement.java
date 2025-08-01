package controlflow;

/*
break : termine la boucle ou le switch
continue : continue la boucle
return : sort de la methode en cours et on retourne a l'appel de la methode
 */
public class ContinueStatement {
    public static void main(String[] args) throws InterruptedException {
        for(int num = 10; num>=0; num--){
            if(num %2 ==1){
                continue;
            }
            System.out.println(num);
        }

        String[] animals = {"Monkey","Bee","Cat","Dog","Cow"};

        for(String animal : animals){
            if(animal == "Dog"){
                continue;
            }
            //Dog n'est pas affiché -> on passe directement dans l'iteration suivante avec le continue
            System.out.println(animal);
        }

        //cas particulier : le index++ est apres le continue, que vas til se passer ? boucle infinie
        //pour eviter cette boucle infinie, on met l'increment avant le if (mais apres la lecture du tableau)
        int index=0;
        String animal;
        while(index < animals.length){
            animal = animals[index];
            System.out.println(animal);
            Thread.sleep(1000);
            if(animal == "Cow")
                continue;
            System.out.println(animal);
            index++;
        }
    }
}
