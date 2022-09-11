package Thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> email = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails () {
        synchronized (email) {
            return email.size();
        }
    }

    public void addMemberToEmail(String email) {
        synchronized (email) {
            System.out.println(Thread.currentThread().getName() + "Adicionou email na lista");
            this.email.add(email);
            email.notifyAll();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checando se tem emails ");
        synchronized (this.email) {
            while(this.email.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + "Nao tem email disponivel na lista, entrando em modo de espera");
                this.email.wait();
            }
            return this.email.poll();
        }
    }

    public void close() {
        open = false;
        synchronized (this.email) {
            System.out.println(Thread.currentThread().getName() + "Fechando");
        }
    }
}
