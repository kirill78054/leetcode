package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ConditionBufferTest {

    @SneakyThrows
    @Test
    public void call() {
        BoundedBuffer bb = new BoundedBuffer();

        new Thread(() -> System.out.println(bb.take())).start();
        new Thread(() -> System.out.println(bb.take())).start();

        SECONDS.sleep(2);
        new Thread(() -> bb.put(1)).start();
        new Thread(() -> bb.put(1)).start();

        SECONDS.sleep(5);
    }

    static class BoundedBuffer {
        private final Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();
        Integer[] mass = new Integer[1];

        @SneakyThrows
        public void put(int i) {
            lock.lock();
            System.out.println(LocalDateTime.now() + " put lock name = " + Thread.currentThread().getName());
            try {
                while (mass[0] != null) {
                    System.out.println(LocalDateTime.now() + " put await name = " + Thread.currentThread().getName());
                    notFull.await();
                }
                mass[0] = i;
                notEmpty.signal();
                System.out.println(LocalDateTime.now() + " put finish name = " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }

        @SneakyThrows
        public int take() {
            lock.lock();
            System.out.println(LocalDateTime.now() + " take lock name = " + Thread.currentThread().getName());
            try {
                while (mass[0] == null) {
                    System.out.println(LocalDateTime.now() + " take wait name = " + Thread.currentThread().getName());
                    notEmpty.await();
                }
                int i = mass[0];
                mass[0] = null;
                notFull.signal();
                System.out.println(LocalDateTime.now() + " take finish name = " + Thread.currentThread().getName());
                return i;
            } finally {
                lock.unlock();
            }
        }
    }

}
