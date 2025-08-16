package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class printEvenOddNumbersUsingExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).forEach(num -> {
                    CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(num).thenApplyAsync(
                        x -> {
                            if (x % 2 != 0) {
                                System.out.println("Thread name: " + Thread.currentThread().getName() + ", value: " + x);
                            }
                            return num;
                        }, executorService
                    );
                    oddCompletableFuture.join();

                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num).thenApplyAsync(
                            x -> {
                                if (x % 2 == 0) {
                                    System.out.println("Thread name: " + Thread.currentThread().getName() + ", value: " + x);
                                }
                                return num;
                            }, executorService
                    );
                    evenCompletableFuture.join();
        });
    }
}
