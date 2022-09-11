package Concorrencia;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollar = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return 4.35D;
            }
        });
        long l = doinSomething();
        System.out.println(l);
        Double aDouble = null;
        try {
            aDouble = dollar.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("DOLLAR DEMOROU MUITO PARA RESPONDER");
        }
        System.out.println("Valor do dolár: " + aDouble);
        executorService.shutdown();
    }

    private static long doinSomething() {
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 10_000_00; i++) {
            sum+=1;
        }
        return sum;
    }
}




