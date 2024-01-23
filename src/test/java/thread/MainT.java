package thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    public int counter = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized void incrementCount() {
        counter++;
    }

    public void incrementAtomic() {
        atomicInteger.incrementAndGet();
    }
}

class AtomRel implements Callable<Integer> {
    private final Counter counter;
    private final int count;

    public AtomRel(Counter counter, int count) {
        this.counter = counter;
        this.count = count;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < count; i++) {
            counter.incrementAtomic();
        }

        System.out.println("Name " + Thread.currentThread().getName() + " counter = " + counter.atomicInteger.get());
        return counter.atomicInteger.get();
    }

}

class VolRel implements Callable<Integer> {
    private final Counter counter;
    private final int count;

    public VolRel(Counter counter, int count) {
        this.counter = counter;
        this.count = count;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < count; i++) {
            counter.incrementCount();
        }

        System.out.println("Name " + Thread.currentThread().getName() + " counter = " + counter.counter);
        return counter.counter;
    }

}

public class MainT {
    static Counter s = new Counter();

    @SneakyThrows
    public static void main(String[] args) {
        int thread = 5;
        int count = 1000_000;
        ExecutorService service = Executors.newFixedThreadPool(thread);

        List<Callable<Integer>> listOne = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            listOne.add(new AtomRel(s, count));
        }
        service.invokeAll(listOne);

        List<Callable<Integer>> listTwo = new ArrayList<>();
        for (int i = 0; i < thread; i++) {
            listTwo.add(new VolRel(s, count));
        }
        service.invokeAll(listTwo);

        System.out.println("\n");
        System.out.println("Finish atomic counter = " + s.atomicInteger.get());
        System.out.println("Finish volatile counter = " + s.counter);
        service.shutdown();
    }

}
