package Concorrencia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("William");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.println("Trying to add another value");
        new Thread(new removeFromQueue(bq)).start();
        bq.put("Suane");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), bq.peek());
    }

    static class removeFromQueue implements Runnable {
        private final BlockingQueue<String> bq;

        public removeFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s Going to sleep for 5 seconds %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s Removing value from queue %n", Thread.currentThread().getName(), bq.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
