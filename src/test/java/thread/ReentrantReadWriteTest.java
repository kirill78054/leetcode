package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ReentrantReadWriteTest {

    @SneakyThrows
    @Test
    public void call() {
        ReadWriteMap map = new ReadWriteMap();
        new Thread(() -> map.put(1, "1")).start();
        new Thread(() -> map.get(1)).start();
        new Thread(() -> map.get(1)).start();
        new Thread(() -> map.get(1)).start();

        SECONDS.sleep(8);
    }

    static class ReadWriteMap {
        private final Map<Integer, String> map;
        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private final Lock read = lock.readLock();
        private final Lock write = lock.writeLock();

        public ReadWriteMap() {
            this.map = new HashMap<>();
        }

        @SneakyThrows
        public String put(Integer key, String value) {
            write.lock();
            System.out.println(LocalDateTime.now() + " put lock start name = " + Thread.currentThread().getName());
            try {
                SECONDS.sleep(2);
                System.out.println(LocalDateTime.now() + " put lock finish name = " + Thread.currentThread().getName());
                return map.put(key, value);
            } finally {
                write.unlock();
            }
        }

        @SneakyThrows
        public String get(Integer key) {
            read.lock();
            try {
                System.out.println(LocalDateTime.now() + " get lock start name = " + Thread.currentThread().getName());
                String result = map.get(key);
                System.out.println(LocalDateTime.now() + " get lock finish name = " + Thread.currentThread().getName());
                return result;
            } finally {
                read.unlock();
            }
        }
    }

}

