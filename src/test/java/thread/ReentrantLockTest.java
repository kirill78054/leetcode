package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.toList;

public class ReentrantLockTest {

    @SneakyThrows
    @Test
    public void call() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletionService<Void> service = new ExecutorCompletionService<>(executor);

        Lock lock = new ReentrantLock(true);
        List<Callable<Void>> callables = Arrays.asList(
                new Inner(lock),
                new Inner(lock)
        );

        List<Future<Void>> collect = callables.stream()
                .map(service::submit)
                .collect(toList());

        while (!collect.isEmpty()) {
            Future<Void> take = service.take();
            collect.remove(take);
        }

        SECONDS.sleep(10);
    }

    static class Inner implements Callable<Void> {
        final Lock lock;

        Inner(Lock lock) {
            this.lock = lock;
        }

        @Override
        public Void call() throws Exception {
            boolean bool = lock.tryLock(3, SECONDS);
            System.out.println("bool = " + bool + ", thread = " + Thread.currentThread().getName());
            if (!bool) {
                System.out.println("Не получил замка, thread = " + Thread.currentThread().getName());
            } else {
                System.out.println("Получил замок, thread = " + Thread.currentThread().getName());
                SECONDS.sleep(5);
            }
            System.out.println("Финалочка, thread = " + Thread.currentThread().getName());
            lock.unlock();
            return null;
        }
    }

}