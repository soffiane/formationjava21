package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map n'est pas dans l'arbre d'heritage de Collection
 * Represente une collection de paires [Cle,Valeur]
 * La clé doit etre unique dans une Map
 * Implementations
 * HashMap : ne respecte pas l'ordre d'insertion
 * LinkedHashMap : respecte l'ordre d'insertion des elements
 * TreeMap : trie les elements par ordre croissant - alphabetique
 */
public class MapInterface {

    public static void main(String[] args) {
        Map<String,Integer> carsMap = new HashMap<>();
        carsMap.put("Mercedes",40000);
        carsMap.put("Ferrari",35000);
        carsMap.put("BMW",40000);
        carsMap.put("BMW",25000);//le deuxieme put avec la cle BMW a ecrasé la premiere
        carsMap.put("Ford",20000);

        carsMap.remove("Ford");
        carsMap.replace("Mercedes",50000);

        System.out.println("carsMap = "+carsMap);//comme pour HashSet, les elements ne sont pas affichés dans leur ordre d'entrée
        System.out.println("price of BMW = "+carsMap.get("BMW"));

        //loop sur les map avec la clé
        for(String car : carsMap.keySet()){
            System.out.println("Price of "+car+ " is "+carsMap.get(car));
        }

        //loop avec la valeur entry
        for(Map.Entry<String, Integer> mapEntry : carsMap.entrySet()){
            //on a acces a la cle et valeur de la map
            System.out.println("Price of "+mapEntry.getKey()+ " is "+mapEntry.getValue());
        }

        /*-------------------------------------- LINKEDHASHMAP -------------------------------------------*/
        Map<String,Integer> carsLinkedHashMap = new LinkedHashMap<>();
        carsLinkedHashMap.put("Mercedes",40000);
        carsLinkedHashMap.put("Ferrari",35000);
        carsLinkedHashMap.put("BMW",40000);
        carsLinkedHashMap.put("Ford",20000);
        System.out.println("carsLinkedHashMap = "+carsLinkedHashMap);//affche par ordre d'insertion

        /*-------------------------------------- TREEMAP -------------------------------------------*/
        TreeMap<String,Integer> carsTreeMap = new TreeMap<>();
        carsTreeMap.put("Mercedes",40000);
        carsTreeMap.put("Ferrari",35000);
        carsTreeMap.put("BMW",40000);
        carsTreeMap.put("Ford",20000);
        System.out.println("carsTreeMap = "+carsTreeMap);//classé par ordre alphabetique des cles
        /*System.out.println("carsTreeMap descending order : "+carsTreeMap.descendingMap());
        System.out.println("carsTreeMap descending order key set : "+carsTreeMap.descendingKeySet());*/
        carsTreeMap.remove("BMW");
        for(Map.Entry<String,Integer> carsTreeMapEntry : carsTreeMap.entrySet()){
            System.out.println(carsTreeMapEntry.getKey()+" "+carsTreeMapEntry.getValue());
        }

        for(String car : carsTreeMap.keySet()){
            System.out.println("Price of "+car+ " is "+carsTreeMap.get(car));
        }
    }
}
