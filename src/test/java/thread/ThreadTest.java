package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Sync {
    int i = 0;

    public synchronized void call1() {
        i++;
    }

    public synchronized void call2() {
        i++;
    }
}

public class ThreadTest {

    @SneakyThrows
    @Test
    public void call() {
        Sync s = new Sync();
        ExecutorService service = Executors.newFixedThreadPool(20);
        List<Callable<Void>> listOne = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1000_000; j++) {
                listOne.add(() -> {
                    s.call1();
                    return null;
                });
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1000_000; j++) {
                listOne.add(() -> {
                    s.call2();
                    return null;
                });
            }
        }

        service.invokeAll(listOne);
        System.out.println("Finish volatile counter = " + s.i);
        service.shutdown();
    }

}
