package Concorrencia;

import java.util.Objects;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Breno"));
        System.out.println(tq.offer("Marisa"));
        tq.put("Marin");
        tq.transfer("Marin");
        System.out.println(tq.offer("Yass", 10, TimeUnit.SECONDS));
        System.out.println(tq.peek());
        System.out.println(tq.remove());
        System.out.println(tq.element());
        System.out.println(tq.poll());
        System.out.println(tq.remainingCapacity());
    }
}
