package exampreparation;

/**
 * Une classe qui extends ou implements une classe/interface sealed
 * doit preciser si elle est final sealed ou non-sealed
 * sealed classes must have subclasses
 */
abstract sealed interface Content permits Story, Art{
    default String getTitle(){return "Title";}
}

non-sealed interface Story extends Content {}
non-sealed interface Art extends Content{}//Art ne peut pas etre une classe
