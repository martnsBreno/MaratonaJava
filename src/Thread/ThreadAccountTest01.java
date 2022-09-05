package Thread;

public class ThreadAccountTest01 implements Runnable {
    private Account conta = new Account();

    public static void main(String[] args) {
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Breninho");
        Thread t2 = new Thread(threadAccountTest01, "Yass");
        t2.start();
        t1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            withDrawl(10);
            if (conta.getBalance() < 0) {
                System.out.println("Lascou, saldo ta negativo");
            }
        }
    }

    private synchronized void withDrawl(int amount) {
        if (conta.getBalance() >= amount) {
            System.out.println(getThreadName()+ " Indo Sacar o dimdim");
            conta.withDrawl(amount);
            System.out.println(getThreadName() + " Dimdim sacado, sobrou : " + conta.getBalance());

        } else {
            System.out.println("Sem dinheiro para " + getThreadName() + " Efetuar o saque " + conta.getBalance());
        }
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
