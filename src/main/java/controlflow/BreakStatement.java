package controlflow;

/*
break : termine la boucle ou le switch
continue : continue la boucle
return : sort de la methode en cours et on retourne a l'appel de la methode
 */
public class BreakStatement {
    public static void main(String[] args) {

        for(int x = 15; x>= 0;x--){
            if(x==5)
                break;
            System.out.println("x = "+x);
        }

        String[] animals = {"Monkey","Bee","Cat","Dog","Cow"};

        int index = 0;
        String animal = "";
        while(index< animals.length){
            animal = animals[index];
            if("Dog".equalsIgnoreCase(animal))
                break;
            index++;
        }
        System.out.println(animal);
    }
}
