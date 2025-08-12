package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set : non ordonnée d'objet uniques : pas de doublons
 * implementations : HashSet, LinkedHashSet
 * SortedSet : ordonnée objet uniques
 * implementation : TreeSet
 * meme methode que List
 *
 * Hashset ne garantie pas l'ordre d'insertion contrairement a LinkedHashSet
 * TreeSet trie ses elements par ordre croissant/alphabetique
 */
public class SetInterface {
    public static void main(String[] args) {
        Set<String> animalsSet = new HashSet<>();
        animalsSet.add("Cat");
        animalsSet.add("Dog");
        animalsSet.add("Cow");
        animalsSet.add("Lion");
        animalsSet.add("Ant");
        animalsSet.add("Dog");

        System.out.println("animalsSet : "+animalsSet);
        System.out.println("size of animalsSet : "+animalsSet.size());
        animalsSet.remove("Cow");
        System.out.println("animalsSet : "+animalsSet);
        System.out.println("animalsSet contains sheep  : "+animalsSet.contains("Sheep"));

        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(12);
        set1.add(13);
        set1.add(17);
        set1.add(18);
        set1.add(16);
        set1.add(14);

        Set<Integer> set2 = new HashSet<>();
        set2.add(10);
        set2.add(12);
        set2.add(12);
        set2.add(15);
        set2.add(13);
        set2.add(19);
        set2.add(13);

        //3 types de comparaison


        System.out.println("Complete set1 : "+set1);
        System.out.println("Complete set2 : "+set2);
        //Intersection entre deux listes -> retainAll()
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection : "+intersectionSet);//les elements en commun dans les deux Set
        //Combiner deux Set -> union -> addAll()
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("unionSet : "+unionSet);//les elements combinés des 2 Set (toujours sans les doublons)
        //Difference entre deux Set -> removeAll()
        Set<Integer> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        System.out.println("differenceSet : "+differenceSet);//les elements qui different entre les deux Set


        //HashSet
        HashSet<String> carsHashSet = new HashSet<>();
        carsHashSet.add("Mercedes");
        carsHashSet.add("BMW");
        carsHashSet.add("Ferrari");
        carsHashSet.add("Ferrari");
        carsHashSet.add("Ford");
        carsHashSet.add("Opel");
        carsHashSet.add("Opel");
        carsHashSet.add("Honda");

        System.out.println("carsHashSet : " + carsHashSet);//les elements ne sont pas affichés dans l'ordre d'insertion

        //LinkedHashSet
        HashSet<String> carsLinkedHashSet = new LinkedHashSet<>();
        carsLinkedHashSet.add("Mercedes");
        carsLinkedHashSet.add("BMW");
        carsLinkedHashSet.add("Ferrari");
        carsLinkedHashSet.add("Ferrari");
        carsLinkedHashSet.add("Ford");
        carsLinkedHashSet.add("Opel");
        carsLinkedHashSet.add("Opel");
        carsLinkedHashSet.add("Honda");
        carsLinkedHashSet.add(null);//on peut mettre null mais une seule fois du coup
        carsLinkedHashSet.add(null);

        System.out.println("carsLinkedHashSet : " + carsLinkedHashSet);//les elements sont affichés dans l'ordre d'insertion

        //TreeSet
        TreeSet<Character> chars = new TreeSet<>();
        chars.add('P');
        chars.add('L');
        chars.add('R');
        chars.add('W');
        chars.add('W');
        chars.add('N');
        chars.add('B');
        chars.add('T');
        chars.add('T');
        chars.add('A');

        System.out.println("descending order : " + chars.descendingSet());
        System.out.println("chars : " + chars);
        //renvoie les elements avant celui passer en parametre, booleen permet de dire si on prend l'element en plus ou pas
        System.out.println("headset = " + chars.headSet('N', false));
        //retourne le sous ensemble compris entre les deux bornes, booleen pour inclure ou pas dans le resultat
        System.out.println("subset = "+chars.subSet('L',true,'T',false));
        //renvoie les elements apres celui passer en parametre, booleen permet de dire si on prend l'element en plus ou pas
        System.out.println("tailset = "+chars.tailSet('N'));
        System.out.println("first = "+chars.first());
        System.out.println("last = "+chars.last());
        System.out.println("remove first element = "+chars.pollFirst());
        System.out.println("remove last element = "+chars.pollLast());
    }

}
