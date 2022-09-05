package Thread;

public class Deadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Runnable r1 = () -> {
            synchronized (lock1) {
                System.out.println("Thread1 segurando o lock 1");
                System.out.println("Esperando o lock 2");
                synchronized (lock2) {
                    System.out.println("Thread1 segurando o lockv 2");
                }
            }
        };
        Runnable r2 = () -> {
            synchronized (lock2) {
                System.out.println("Thread2 segurando o lock 2");
                System.out.println("Esperando o lock 1");
                synchronized (lock1) {
                    System.out.println("Thread2 segurando o lockv 1");
                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
