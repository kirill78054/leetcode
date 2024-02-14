package thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    static Counter s = new Counter();

    @SneakyThrows
    public static void main(String[] args) {
        int thread = 5;
        int count = 1000_000;
        ExecutorService service = Executors.newFixedThreadPool(thread);

        List<Callable<Integer>> listOne = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            listOne.add(new AtomicCounter(s, count));
        }
        service.invokeAll(listOne);

        List<Callable<Integer>> listTwo = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            listTwo.add(new SyncCounter(s, count));
        }
        service.invokeAll(listTwo);

        System.out.println("\n");
        System.out.println("Finish atomic counter = " + s.counterAtomic.get());
        System.out.println("Finish volatile counter = " + s.counterSync);
        service.shutdown();
    }

    static class Counter {
        public int counterSync = 0;
        AtomicInteger counterAtomic = new AtomicInteger();

        public synchronized void incrementCount() {
            counterSync++;
        }

        public void incrementAtomic() {
            counterAtomic.incrementAndGet();
        }
    }

    static class AtomicCounter implements Callable<Integer> {
        private final Counter counter;
        private final int count;

        public AtomicCounter(Counter counter, int count) {
            this.counter = counter;
            this.count = count;
        }

        @Override
        public Integer call() {
            for (int i = 0; i < count; i++) {
                counter.incrementAtomic();
            }

            System.out.println("Name " + Thread.currentThread().getName() + " counter = " + counter.counterAtomic.get());
            return counter.counterAtomic.get();
        }

    }

    static class SyncCounter implements Callable<Integer> {
        private final Counter counter;
        private final int count;

        public SyncCounter(Counter counter, int count) {
            this.counter = counter;
            this.count = count;
        }

        @Override
        public Integer call() {
            for (int i = 0; i < count; i++) {
                counter.incrementCount();
            }

            System.out.println("Name " + Thread.currentThread().getName() + " counter = " + counter.counterSync);
            return counter.counterSync;
        }

    }

}
