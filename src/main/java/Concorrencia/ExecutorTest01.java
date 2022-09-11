package Concorrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class printer implements Runnable {
    private int num;

    public printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s iniciou %s%n", Thread.currentThread().getName(), num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finalizou %n", Thread.currentThread().getName());
    }
}
public class ExecutorTest01 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new printer(1));
        executorService.execute(new printer(2));
        executorService.execute(new printer(3));
        executorService.execute(new printer(4));
        executorService.execute(new printer(5));
        executorService.execute(new printer(6));
        executorService.shutdown();
        System.out.println("Progama finalizado");
    }
}
