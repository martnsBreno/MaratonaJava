package Concorrencia;
import java.util.concurrent.locks.ReentrantLock;

class worker implements Runnable {

    private String name;
    private ReentrantLock lock;

    public worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if (lock.isHeldByCurrentThread()) {
                System.out.printf("Thread %s entrou em uma sessao critica%n", name);
            }
            System.out.printf("%d Threads esperando na fila", lock.getQueueLength());
            System.out.printf("%s Thread vai esperar 2s", name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Thread %s finalizou a espera", name);
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockTest01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new worker("A", lock)).start();
        new Thread(new worker("B", lock)).start();
        new Thread(new worker("C", lock)).start();
        new Thread(new worker("D", lock)).start();
        new Thread(new worker("E", lock)).start();
    }
}
