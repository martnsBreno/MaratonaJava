package Concorrencia;

import Concorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StoreService storeService = new StoreService();
        searchPricesAsyncFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService) {
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Amazon"));
        System.out.println(storeService.getPriceSync("Nethoes"));
        System.out.println(storeService.getPriceSync("Aliexpress"));
        System.out.println(storeService.getPriceSync("Shopee"));
        System.out.println(storeService.getPriceSync("Kabum"));
        long end = System.currentTimeMillis();
        System.out.println("Time passed till getPriceSync was completed" + (end - start));
    }

    private static void searchPricesAsyncFuture(StoreService storeService) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Double> amazon = storeService.getPricesAsyncFuture("Amazon");
        CompletableFuture<Double> nethoes = storeService.getPricesAsyncFuture("Nethoes");
        CompletableFuture<Double> aliexpress = storeService.getPricesAsyncFuture("Aliexpress");
        CompletableFuture<Double> shopee = storeService.getPricesAsyncFuture("Shopee");
        CompletableFuture<Double> kabum = storeService.getPricesAsyncFuture("Kabum");
        long end = System.currentTimeMillis();
        System.out.println("Time passed till getPriceSync was completed" + (end - start));
    }
}
