package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SynkTwoMethodsTest {

    @SneakyThrows
    @Test
    public void call() {
        ServerStatus s = new ServerStatus();

        Runnable first = () -> s.addUser("first");
        Runnable second = () -> s.addQuery("second");

        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(first);
        ex.submit(second);

        SECONDS.sleep(10);
        System.out.println("Finish");
    }

    public static class ServerStatus {
        public final Set<String> users = new HashSet<>();
        public final Set<String> queries = new HashSet<>();

        @SneakyThrows
        public void addUser(String u) {
            synchronized (users) {
                users.add(u);
                System.out.println("Start addUser, thread = " + Thread.currentThread().getName());
                SECONDS.sleep(3);
                System.out.println("Finish addUser, thread = " + Thread.currentThread().getName());
            }
        }

        @SneakyThrows
        public void addQuery(String q) {
            synchronized (queries) {
                queries.add(q);
                System.out.println("Start addQuery, thread = " + Thread.currentThread().getName());
                SECONDS.sleep(2);
                System.out.println("Finish addQuery, thread = " + Thread.currentThread().getName());
            }
        }
    }

}
