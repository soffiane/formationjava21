package advancedthreadtopics;


import java.util.concurrent.locks.StampedLock;

/**
 * data consistency et performance -> essentiel
 * les mecanismes simples tels que les bloc synchronized sont simple et efficace mais peuvent etre trop restrictifs, mene a de la contention et baisse perf
 * les mecanisme avancées offrent plus de controle et de flexibilité
 * 3 mecanismes :
 * ReentrantLock:
 * lock et unlock EXPLICITES
 * fairness -> les locks sont attribés aux thread dans l'ordre d'arrivée
 * Interruptibility -> un thread peut etre mis en attente pour un lock
 * Try Lock -> essaie de prendre un lock seulement si il est disponible
 *
 * ReadWriteLock:
 * + threads peuvent lire le meme lock; 1 seul peut ecrire
 * ameliore la lecture
 *
 * StampedLock:
 * Java 8
 * Stamped based locking : distribue un tampon, seul ceux qui ont le tampon peuvent avoir le lock
 * 3 types :
 * Write Lock : comme le lock normal
 * Read Lock :+ thread peuvent lire un seul peut ecrire
 * Optimisitc Read : la lecture ne bloque pas l'ecriture, si lecteur a lieu pendant l'ecriture on appelle la methode validate() pour etre sur de la valeur
 * le stamp a un compteur ce compteur sert au OptimiticRead de prevenir de la non constitence de la lecture
 * Ideal pour beaucoup de read et peu de write
 * Pas de fairness -> thread starvation
 * Use cases
 */
public class AdvancedLockMecanisms {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Runnable depositTask = () -> {
            for(int i =0;i<6;i++){
                bankAccount.deposit(100);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable withDrawTask = () -> {
            for(int i =0;i<6;i++){
                try{
                    bankAccount.withdraw(50);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable optimistic = () -> {
            for(int i =0;i<6;i++){
                try{
                    bankAccount.getBalanceOptimistic();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(depositTask,"deposit-thread");
        Thread t2 = new Thread(withDrawTask, "withraw-thread");
        Thread t3 = new Thread(optimistic, "optimistic-thread");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance : "+bankAccount.getBalance());
    }
}

class BankAccount {
    private double balance = 0;//data to protect

    private final StampedLock stampedLock = new StampedLock();

    public void deposit(double amount){
        long stamp = stampedLock.writeLock();
        try{
            System.out.println(Thread.currentThread().getName()+ " depositing "+amount);
            balance+= amount;
            System.out.println(Thread.currentThread().getName()+ " new balance "+balance);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public void withdraw(double amount){
        long stamp = stampedLock.readLock();
        try{
            if(balance >= amount){
                balance -= amount;
                System.out.println(Thread.currentThread().getName()+ " withdraw "+amount);
            } else {
                System.out.println(Thread.currentThread().getName()+ " insufficient balance ");
            }
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public double getBalanceOptimistic(){
        long stamp = stampedLock.tryOptimisticRead();
        double currentbalance = balance;

        if(stampedLock.validate(stamp)){
            stamp = stampedLock.readLock();
            try{
                currentbalance = balance;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+ " reading balance "+balance);
        return currentbalance;
    }

    public double getBalance() {
        long stamp = stampedLock.readLock();
        try {
            return balance;
        } finally {
            stampedLock.unlockRead(stamp);
        }

    }
}
