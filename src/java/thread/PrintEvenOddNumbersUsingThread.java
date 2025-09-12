package java.thread;

public class PrintEvenOddNumbersUsingThread  implements Runnable {
    static int count = 1;
    private final Object lock;
    private final boolean isEvenThread;

    public PrintEvenOddNumbersUsingThread(Object lock, boolean isEvenThread) {
        this.lock = lock;
        this.isEvenThread = isEvenThread;
    }

    @Override
    public void run() {
        while (count <= 100) {
            if(count % 2 == 0 && isEvenThread) {
                synchronized (lock) {
                    System.out.println("Thread running, name: " + Thread.currentThread().getName()  + ", value: " + count);
                    count++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notifyAll();
                }
            }
            if(count % 2 == 1 && !isEvenThread) {
                synchronized (lock) {
                    System.out.println("Thread running, name: " + Thread.currentThread().getName()  + ", value: " + count);
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable pth1 = new PrintEvenOddNumbersUsingThread(lock, true);
        Runnable pth2 = new PrintEvenOddNumbersUsingThread(lock, false);
        new Thread(pth1, "even").start();
        new Thread(pth2, "odd").start();
    }
}
