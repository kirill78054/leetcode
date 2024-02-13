package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.time.LocalDateTime;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitNotifyAllBufferTest {

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
        private final Object lock = new Object();
        Integer[] mass = new Integer[1];

        @SneakyThrows
        public void put(int i) {
            synchronized (lock) {
                System.out.println(LocalDateTime.now() + " put start name = " + Thread.currentThread().getName());
                while (isFull()) {
                    lock.wait();
                }
                mass[0] = i;
                lock.notifyAll();
                System.out.println(LocalDateTime.now() + " put finish name = " + Thread.currentThread().getName());
            }
        }

        @SneakyThrows
        public int take() {
            synchronized (lock) {
                System.out.println(LocalDateTime.now() + " take start name = " + Thread.currentThread().getName());
                while (isEmpty()) {
                    System.out.println(LocalDateTime.now() + " take wait name = " + Thread.currentThread().getName());
                    lock.wait();
                }

                int i = mass[0];
                mass[0] = null;
                lock.notifyAll();
                System.out.println(LocalDateTime.now() + " take finish name = " + Thread.currentThread().getName());
                return i;
            }
        }

        private boolean isFull() {
            synchronized (lock) {
                return mass[0] != null;
            }
        }

        private boolean isEmpty() {
            synchronized (lock) {
                return mass[0] == null;
            }
        }

    }


}
