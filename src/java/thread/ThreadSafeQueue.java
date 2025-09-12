package java.thread;

import java.util.*;

public class ThreadSafeQueue<T> {
    private final Queue<T> threadedQueue;

    public ThreadSafeQueue() {
        this.threadedQueue = new LinkedList<>();
    }

    public synchronized void add(T value) {
        threadedQueue.offer(value);
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        if(threadedQueue.isEmpty()) {
            wait(); // wait till there is a new data
            System.out.println("ThreadedQueue is empty. Consumer waits for new data...");
        }
        T val = threadedQueue.poll();
        notifyAll();
        return val;
    }

    public static void main(String[] args) {
        ThreadSafeQueue<Integer> threadSafeQueue = new ThreadSafeQueue<>();

        Runnable producerTask = () -> {
            for (int i = 0; i < 10; i++) {
                threadSafeQueue.add(i);
                System.out.println("Thread name: " + Thread.currentThread().getName() + ", value: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    threadSafeQueue.get();
                    System.out.println("Thread name: " + Thread.currentThread().getName() + ", value: " + i);
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(consumerTask, "Consumer").start();
        new Thread(producerTask, "Producer-1").start();
        new Thread(producerTask, "Producer-2").start();

        List<Integer> totalNumbers = new ArrayList<>();
        totalNumbers.add(2);
       List<Integer> numbers = totalNumbers.stream().filter(e -> e > 2).toList();
    }
}
