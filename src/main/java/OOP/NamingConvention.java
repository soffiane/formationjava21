package OOP;

/**
 * class name : commence par une majuscule et doit etre un nom
 * method name : commence par une minuscule et peut etre un verbe
 * variable name : commence par une minuscule et les mots apres commence par majuscule : firstName CAMEL CASE
 * java est case sensitive
 *
 * On peut mettre un $ ou _ devant un nom de classe
 */
public class NamingConvention {

    //valide
    int java;
    int _java;
    int $java;
    int _$java;
    int __$java_$;
    int $public;
    int Private;
    int _public;
    int _private;

    //invalide
    /*int 1java;
    int &java;
    int java@java;
    int public;*/

    void java(){}
    void _java(){}
    void $java(){}
    void _$java(){}
    void Java(){}//non recommendé - camel case
}
