package OOP.polymorphism;

sealed class Account permits BankAccount {
    public void methodA() {
        System.out.println("Method A");
    }
}

sealed class BankAccount extends Account permits CreditAccount {
    public void methodB() {
        System.out.println("Method B");
    }
}

non-sealed class CreditAccount extends BankAccount {
    public void methodC() {
        System.out.println("Method C");
    }
}

/**
 * nouvelle syntaxe Java14 de instanceof
 */
class MyMain {
    public static void main(String[] args) {
        Account ba = new BankAccount();
        Account ca = new CreditAccount();
        //si ca est une instance de BankAccount  on le met dans la variable b
        //c'est une instance de CreditAccount qui herite de BankAccount donc true
        if (ca instanceof BankAccount b) {
            //ici b est de type BankAccount
            b.methodB();
            //CreditAccount herite de BankAccount donc true
            if (b instanceof CreditAccount c) {
                c.methodC();
            }
        } else {
            ca.methodA();
        }
        //Output
        //Method B
        //Method C
        //
        Object obj = new Object();
        /*if(obj instanceof String name & name.length() >10){
            var xPosition = 10;
            var yPosition = 0;
        }*/
        if(obj instanceof String name && name.length() >10){
            var xPosition = 10;
            var yPosition = 0;
        }
        /*if(obj instanceof String name | name.length() >10){
            var xPosition = 10;
            var yPosition = 0;
        }*/


    }
}
