package Concorrencia.service;

import java.util.concurrent.*;

public class StoreService {
    private static final ExecutorService ex = Executors.newCachedThreadPool();
    public double getPriceSync(String storeName) {
        System.out.printf("%s generating price%n", storeName);
        return priceGenerator();
    }

    public CompletableFuture<Double> getPricesAsyncFuture(String storeName) {
        System.out.printf("Getting sync prices for store %s%n", storeName);
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }

    private double priceGenerator(){
        System.out.printf("%s generating pricce %n", Thread.currentThread().getName());
        try {
            delay();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    private void delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
