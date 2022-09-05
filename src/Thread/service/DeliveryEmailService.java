package Thread.service;
import Thread.Members;

public class DeliveryEmailService implements Runnable{
    private final Members members;

    public DeliveryEmailService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "começando a enviar os emaisl");
        while (members.isOpen() || members.pendingEmails() > 0) {
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.println(threadName + "enviando email para " + email );
                Thread.sleep(1000);
                System.out.println(threadName + "enviou email com sucesso para " + email);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("todos emails enviados com sucesso para seu destinatario");
    }
}
