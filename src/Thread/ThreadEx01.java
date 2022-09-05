package Thread;

class ThreadExample extends Thread {
    private char c;
    public ThreadExample(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 100; i++) {
            System.out.print(c);
        }
    }
}

class ThreadExampleRunnable implements Runnable {

    private char c;
    public ThreadExampleRunnable(char c) {
        this.c = c;
    }


    @Override
    public void run() {
        for (int i = 0 ; i < 100; i++) {
            System.out.print(c);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadEx01 {
    public static void main(String[] args) {
//      ThreadExample T1 = new ThreadExample('A');
//      ThreadExample T2 = new ThreadExample('B');
//      ThreadExample T3 = new ThreadExample('C');
//      T1.start();
//      T2.start();
//      T3.start();
        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "Thread 1");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "Thread 2");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "Thread 3");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
