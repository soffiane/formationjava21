package modules;
/**
 * Les modules permettent d'organiser le code afin de deployer et declarer les dependances entre eux dans leurs
 * fichier de description respectifs.
 * Pris en charge par la JVM au meme tire que les packages, classes, interfaces...
 * A partir de java 9, on peut grouper des packages dans un module
 * module doit:
 * - avoir un nom unique dans l'espace de la JVM
 * - avoir un fichier descripteur module-info.java
 * - un module peut dependre d'autres modules
 *
 * Un module nommé doit obligatoirement contenir un descripteur de module.
 * C'est un fichier nommé module-info.java à la racine des sources du module qui contient des informations de configuration concernant le module :
 *
 * le nom du module
 * les packages exportés : une liste de packages dont les éléments publics seront accessibles à l'extérieur du module par d'autres modules qui en dépendent
 * les dépendances du module : les modules requis par le module donc les autres modules dont le module à besoin
 * les packages ouverts : une liste de packages sur lesquels l'introspection pourra être utilisée
 * les services proposés : une ou plusieurs implémentations des services que le module fournit et qui pourront être utilisé par d'autres modules
 * les services fournis ou consommés par le module
 *
 * Un module possède obligatoirement un nom, soit implicite ou explicite.
 *
 * Par défaut, un module est hermétique :
 *
 * aucune classe n'est accessible de l'extérieur du module, même celles qui sont public
 * il n'est pas possible d'utiliser l'introspection sur les classes du module de l'extérieur du module
 * aucune ressource n'est accessible de l'extérieur du module
 *
 * Les informations de description relatives au module sont fournies entre les accolades en utilisant des directives :
 *
 * requires :  Indiquer une dépendance du module. Ce mot clé doit être suivi du nom du module dépendant
 *
 * transitive : S'utilise après le mot clé requires pour indiquer que tous les modules qui auront ce module en dépendances auront
 * aussi implicitement le module précisé après transitive en dépendance
 *
 * exports : Définir un package comme étant exposé en dehors du module ; Permet d'indiquer que les classes publiques du package
 * précisé seront accessibles à l'extérieure du module
 *
 * opens : Indiquer que les éléments du package précisé seront accessibles à l'exécution par l'API Introspection quelque soit
 * leur niveau de visibilité et autorise le chargement de chargement de ressources contenues dans le package
 *
 * open :Indiquer sur un module qu'il est possible de faire de l'introspection sur des éléments et de permettre un chargement des ressources de tous les packages de celui-ci
 *
 * uses : Indiquer que le module utilise le service précisé sous la forme du nom pleinement qualifié de sa classe ou interface
 *
 * provides ... with ... : Indiquer que le module fournit une implémentation du service précisé grâce à la classe dont le nom pleinement qualifié suit with
 */
public class ModulesJava9 {
}
