package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * List est une collection ordonnée d'objet qui accepte les doublons
 * Implementation connue: ArrayList, LinkedList
 * methodes :
 * add() a la fin de la liste par defaut, sinon on precise l'index
 * remove() pareil que add
 * set() change l'element a l'index specifié
 * contains() -> self explanatory
 * isEmpty()
 * clear() -> efface tous les elements de la liste
 * size() -> retourne la taille
 */
public class ListInterface {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();//polymorphisme, on instancie une implementation de l'interface List
        List<Integer> list2 = new ArrayList<>();
        //pas de list avec des primitifs juste des wrappers classes et des objets
        //List<double> list = new ArrayList<>();
        Collection<Integer> list3 = new ArrayList<>();
        //list is a raw type -> type par defaut Object et on peut y ajouter n'importe quoi
        List list5 = new ArrayList();
        list5.add("Hello World");
        list5.add(5);
        String message = (String) list5.get(0);//getFirst() pour acceder au premier element depuis Java21
        int value = (int) list5.get(1);
        System.out.println(message+" "+value);
    }
}
