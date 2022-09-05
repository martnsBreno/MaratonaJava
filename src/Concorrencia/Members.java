package Concorrencia;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members{
    private final Queue<String> email = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return email.size();
        } finally {
            lock.unlock();
        }
    }

    public void addMemberToEmail(String email) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Adicionou email na lista");
            this.email.add(email);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checando se tem emails ");
        lock.lock();
        try {
            while (this.email.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + "Nao tem email disponivel na lista, entrando em modo de espera");
                condition.await();
            }
            return this.email.poll();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Fechando");
        } finally {
            lock.unlock();
        }
    }
}
