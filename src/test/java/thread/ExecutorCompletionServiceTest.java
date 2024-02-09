package thread;


import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExecutorCompletionServiceTest {

    @SneakyThrows
    @Test
    public void call() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        List<Callable<String>> callables = Arrays.asList(
                new DelayedCallable("fast thread", 5000),
                new DelayedCallable("slow thread", 5000));

        List<Future<String>> futures = callables.stream()
                .map(service::submit)
                .collect(toList());

        for (Callable<String> callable : callables) {
            service.submit(callable);
        }

        long startProcessingTime = System.currentTimeMillis();

        System.out.println("Start First poll");
        Future<String> future = service.take();
        System.out.println("Finish First poll");
        String firstThreadResponse = future.get();
        System.out.println("First get");

        long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
        System.out.println("Thread finished after: " + totalProcessingTime + " milliseconds, response = " + firstThreadResponse);

        long canceledFuturesCount = futures.stream()
                .map(f -> f.cancel(false))
                .filter(futureCanceled -> futureCanceled)
                .count();

        System.out.println("canceledFuturesCount = " + canceledFuturesCount);
        System.out.println("Start Second take");
        future = service.take();
        System.out.println("Finish Second take");
        String secondThreadResponse = future.get();
        System.out.println("Second get");
        totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
        System.out.println("Thread finished after: " + totalProcessingTime + " milliseconds, response = " + secondThreadResponse);

        executor.shutdown();
    }

    static class DelayedCallable implements Callable<String> {
        String name;
        int x;

        public DelayedCallable(String name, int x) {
            this.name = name;
            this.x = x;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(x);
            return name;
        }
    }

}
