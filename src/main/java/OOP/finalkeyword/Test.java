package OOP.finalkeyword;

import java.util.ArrayList;

public class Test {

    public static final ArrayList<String> animals = new ArrayList<>();
    public static void main(String[] args) {
        //la liste est final mais on peut quand meme y ajouter des elements
        animals.add("Lion");
        animals.add("Tiger");
        //mais on ne peut pas reassigner la variable avec une nouvelle liste
        //animals = new ArrayList<>(); ----> KO
    }
}
