package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Introduit dans Java21
 * Introduit la possibilité d'acceder au premier/dernier element de la collection
 * Collection qui a un ordre defini
 * Interfaces :
 * SequencedSet qui herite de SequencedCollection,SequencedMap
 * offre une methode reverse() qui n'existe pas dans les LinkedHashSet
 */
public class SequencedCollections {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new LinkedHashMap<>();
    }
}
