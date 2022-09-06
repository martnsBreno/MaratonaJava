package Concorrencia;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private static void beeper() {
        Runnable r = () -> {
            System.out.println(LocalTime.now()+ " beep ");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
//        executor.schedule(r, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
        executor.schedule(() -> {
                System.out.println("Cancelando o scheduledFixedDelay");
                scheduledFuture.cancel(false);
                executor.shutdown();
            }, 10, TimeUnit.SECONDS);

    }


    public static void main(String[] args) {
        beeper();
    }
}
