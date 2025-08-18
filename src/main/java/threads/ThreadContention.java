package threads;

/**
 * Thread contention se produit quand + threads essaie d'acceder a des ressources partageés
 * Ca peut aboutir a des delais car les threads doivent attendre leur tour -> baisse de performance si mal gerée
 * -> trop de synchronized, attendre des IO pour completer, competition pour les lock dans hashmap
 * -> solution : reduire la portée des lock, utiliser des concurrent data structures, optimiser les sections critique de code
 *
 * Deadlock :
 * 2 thread attendent l'un l'autre qu'il libere le lock -> eviter les nested locks, lock ordering, timeouts
 */
public class ThreadContention {
}
