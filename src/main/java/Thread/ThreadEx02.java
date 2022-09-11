package Thread;

class ThreadExampleRunnable2 implements Runnable {

    private String c;
    public ThreadExampleRunnable2(String c) {
        this.c = c;
    }


    @Override
    public void run() {
        for (int i = 0 ; i < 100; i++) {
            System.out.print(c);
            if (i % 100 == 0)
                System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadEx02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"), "Thread 1");
        Thread t2 = new Thread(new ThreadExampleRunnable2("KB"), "Thread 2");
        t1.start();
        t1.join();
        t2.start();
    }
}
